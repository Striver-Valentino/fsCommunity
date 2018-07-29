package club.fsCommunity.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventProducer;
import club.fsCommunity.async.EventType;
import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.mapper.EnrollMapper;
import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.EnrollExample;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.EnrollExample.Criteria;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.EnrollService;

@Service("enrollService")
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	private EnrollMapper enrollMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private EventProducer eventProducer;
	
	
	/**
	 * 添加报名信息（说明有用户在报名页面报名了一个赛事）
	 * @param enroll
	 * @return
	 */
	@Override
	public Map<String, Object> addEnroll(Enroll enroll) {
		
		Map<String,Object> map = new HashMap<>();
		
		if( enroll==null ){
			map.put("msgError", "报名出错");
			return map;
		}
		
		if( StringUtils.isBlank(enroll.getPosition()) ){
			map.put("msgError", "请选择参赛职业");
			return map;
		}
		if(StringUtils.isBlank(enroll.getRating())){
			map.put("msgError", "请选择您的RT");
			return map;
		}
		
		/**
		 * 检查是否 同一用户 报了 同一赛事
		 */
		List<Enroll> list = this.selectEnrollByGameIdAndUserId(enroll.getGameId(),enroll.getUserId());
		System.out.println("报名信息list："+list+"，长度："+list.size());
		if( list.size()!=0 ){
			System.out.println("进来了list判断");
			map.put("msgError", "请不要重复报名同一赛事");
			return map;
		}
		
		
		
		// 如果填写信息没问题，就可以开始提交报名
		enroll.setEnrollId(randomNumberUtil.generateEnrollID());
		enroll.setStatus(0);
		enroll.setEnrollDate(new Date());
		
		// 设置 报名用户的游戏昵称 字段
		User user = userMapper.selectByPrimaryKey(enroll.getUserId());
		System.out.println("addEnroll_enroll.getUserId():" + enroll.getUserId());
		System.out.println("addEnroll_user:" + user);
		enroll.setSignupUserGameName(user.getGameName());
		
		/**
		 *  对于  参赛职业  字段，在数据库 是 String 类型（即varchar），但是 在 实际 代码 操作中 应该是  list 类型 更好，
		 *  所以 ，把 接收 的 参赛职业 字段  先 根据 逗号 分割，存进 一个 List<String> 中，然后 把这个 list 转为 json ，
		 *  json 也是一种 String，把 这个 json 存到数据库。
		 *  需要 读取时，先把 json 读取，然后 再把 json 重新 解析 成 list，就可以 在代码中 使用 这个 list 了。
		 */
		System.out.println("addEnroll_接收报名的参赛职业：" + enroll.getPosition());
		// 根据 逗号 分割；split(",")  将此字符串拆分为给定的regular expression的匹配。 
		// 该方法的工作原理是通过使用给定表达式和限制参数为零调用双参数split方法。 因此，尾随的空字符串不会包含在结果数组中。 
		String[] split = enroll.getPosition().split(",");
		// 存进 一个 List<String> 中
		List<String> positionList = new ArrayList<String>();
		for (int i = 0; i < split.length; i++) {
			positionList.add(split[i]);
		}
		System.out.println("参赛职业list:" + positionList);
		// 把这个 list 转为 json
		String positionJson = JSON.toJSONString(positionList);
		// 重新 设置  json 格式  的  参赛职业
		enroll.setPosition(positionJson);
		
		
		enrollMapper.insert(enroll);
		
		/**
		 * 生成 报名 成功 事件，异步 计算 该报名 信息 的 能力分数 ；并且，对应 的 赛事 报名 人数+1
		 */
		eventProducer.fireEvent(new EventModel(EventType.ENROLLSUC)
				.setExt("enrollId", enroll.getEnrollId())
				.setExt("gameId", enroll.getGameId())
		);
		
		map.put("msgEnrollOK", "EnrollOK");
		
		return map;
	}

	/**
	 * 根据 赛事id 与 用户id 查找 报名信息（可以检查 一个用户 是否 多次 报 同一个 赛事）
	 * @return
	 */
	@Override
	public List<Enroll> selectEnrollByGameIdAndUserId(String gameId,String userId) {
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		criteria.andUserIdEqualTo(userId);
		List<Enroll> list = enrollMapper.selectByExample(example);
		
		return list;
	}

	/**
	 * 根据 用户id 查找 报名信息
	 */
	@Override
	public List<Enroll> selectEnrollByUserId(String userId) {
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		
		// 设置排序，先按 enroll_date 逆向排序，如果 enroll_date 相同 ，再按 game_name 逆向排序
		example.setOrderByClause("`enroll_date` DESC,`signup_game_name` DESC");
		
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	/**
	 * 根据 gameId 查找 参赛用户，封装成 layui 表格 需要的 带有 分页信息 的 实体  LayuiTableData
	 */
	@Override
	public LayuiTableData selectUserByGameId(String gameId, Integer page,
			Integer limit) {
		
		// 开始分页
		PageHelper.startPage(page, limit);
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		// 得到分页信息
		PageInfo<Enroll> pageInfo = new PageInfo<>(list);
		
		LayuiTableData layuiTableData = new LayuiTableData();
		layuiTableData.setCode(0);
		layuiTableData.setMsg("");
		layuiTableData.setCount(pageInfo.getTotal());
		layuiTableData.setData(list);
		
		return layuiTableData;
	}

	/**
	 * 根据 报名信息id 查找 报名信息
	 */
	@Override
	public List<Enroll> selectEnrollByEnrollId(String enrollId) {
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnrollIdEqualTo(enrollId);
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	/**
	 * 更新 报名信息 的 能力 分值
	 */
	@Override
	public Map<String, Object> updateEnrollAbilityScore(String enrollId,
			Integer abilityScore) {
		
		Map<String,Object> map = new HashMap<>();
		
		if( enrollId == null ){
			map.put("updateEnrollScoreError", "更新报名信息能力分值出错，没有 enrollId");
			return map;
		}
		
		if( abilityScore == null ){
			map.put("updateEnrollScoreError", "更新报名信息能力分值出错，没有 abilityScore");
			return map;
		}
		
		Enroll enroll = new Enroll();
		enroll.setAbilityScore(abilityScore);
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnrollIdEqualTo(enrollId);
		
		enrollMapper.updateByExampleSelective(enroll, example);
		
		map.put("updateEnrollScoreSuc", "更新报名信息能力分值成功");
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
