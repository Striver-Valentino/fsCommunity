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
		
		
		List<Enroll> list = this.selectEnrollByGameIdAndUserId(enroll.getGameId(),enroll.getUserId());
		System.out.println("报名信息list："+list+"，长度："+list.size());
		if( list.size()!=0 ){
			System.out.println("进来了list判断");
			map.put("msgError", "请不要重复报名同一赛事");
			return map;
		}
		
		
		
		enroll.setEnrollId(randomNumberUtil.generateEnrollID());
		enroll.setStatus(0);
		enroll.setEnrollDate(new Date());
		
		User user = userMapper.selectByPrimaryKey(enroll.getUserId());
		System.out.println("addEnroll_enroll.getUserId():" + enroll.getUserId());
		System.out.println("addEnroll_user:" + user);
		enroll.setSignupUserGameName(user.getGameName());
		
		
		System.out.println("addEnroll_接收报名的参赛职业：" + enroll.getPosition());
		String[] split = enroll.getPosition().split(",");
		List<String> positionList = new ArrayList<String>();
		for (int i = 0; i < split.length; i++) {
			positionList.add(split[i]);
		}
		System.out.println("参赛职业list:" + positionList);
		String positionJson = JSON.toJSONString(positionList);
		enroll.setPosition(positionJson);
		
		
		enrollMapper.insert(enroll);
		
		
		eventProducer.fireEvent(new EventModel(EventType.ENROLLSUC)
				.setExt("enrollId", enroll.getEnrollId())
				.setExt("gameId", enroll.getGameId())
		);
		
		map.put("msgEnrollOK", "EnrollOK");
		
		return map;
	}

	
	@Override
	public List<Enroll> selectEnrollByGameIdAndUserId(String gameId,String userId) {
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		criteria.andUserIdEqualTo(userId);
		List<Enroll> list = enrollMapper.selectByExample(example);
		
		return list;
	}

	
	@Override
	public List<Enroll> selectEnrollByUserId(String userId) {
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		
		example.setOrderByClause("`enroll_date` DESC,`signup_game_name` DESC");
		
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	
	@Override
	public LayuiTableData selectUserByGameId(String gameId, Integer page,
			Integer limit) {
		
		PageHelper.startPage(page, limit);
		
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		PageInfo<Enroll> pageInfo = new PageInfo<>(list);
		
		LayuiTableData layuiTableData = new LayuiTableData();
		layuiTableData.setCode(0);
		layuiTableData.setMsg("");
		layuiTableData.setCount(pageInfo.getTotal());
		layuiTableData.setData(list);
		
		return layuiTableData;
	}

	
	@Override
	public List<Enroll> selectEnrollByEnrollId(String enrollId) {
		EnrollExample example = new EnrollExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnrollIdEqualTo(enrollId);
		List<Enroll> list = enrollMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	
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
