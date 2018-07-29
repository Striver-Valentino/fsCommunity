package club.fsCommunity.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.fsCommunity.common.pojo.ConditionOfSelectGames;
import club.fsCommunity.common.pojo.DisplayGamesTable;
import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.common.utils.PojoConvertUtils;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.GameExample.Criteria;
import club.fsCommunity.service.SignUpGameService;
import club.fsCommunity.service.IndexService;

@Service
public class SignUpGameServiceImpl implements SignUpGameService {
	
	@Autowired
	private GameMapper gameMapper;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	/**
	 * 根据 搜索条件 查找赛事
	 */
	@Override
	public LayuiTableData getGamesByCondition(Integer page,Integer limit,ConditionOfSelectGames condition) {
		
		System.out.println("SignUpGameServiceImpl_condition:" + condition);
		
		int status = 0;
		Date startDateValue1 = null;
		Date startDateValue2 = null;
		
		if(condition != null){
			// 状态，0：未开始；1：进行中；2：截止报名；3：已结束；4：已取消；5：所有状态（5这个状态是页面需要的，数据库并没有，数据库不需要）
			if(condition.getStatusStr()!=null && !"".equals(condition.getStatusStr().trim())){
				if("0".equals(condition.getStatusStr())){
					status = 0;
				}else if("1".equals(condition.getStatusStr())){
					status = 1;
				}else if("2".equals(condition.getStatusStr())){
					status = 2;
				}else if("3".equals(condition.getStatusStr())){
					status = 3;
				}else if("4".equals(condition.getStatusStr())){
					status = 4;
				}else if("5".equals(condition.getStatusStr())){
					status = 5;
				}
			}
			
			if( condition.getStartDate1()!=null && !"".equals(condition.getStartDate1().trim()) && condition.getStartDate2()!=null && !"".equals(condition.getStartDate2().trim()) ){
				try {
					startDateValue1 = sdf.parse(condition.getStartDate1());
					startDateValue2 = sdf.parse(condition.getStartDate2());
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		// 开始分页
		PageHelper.startPage(page, limit);
		
		GameExample example = new GameExample();
		
		Criteria criteria = example.createCriteria();
		
		// 拼接 搜索条件
		if(condition!=null){
			// 赛事名称
			if(condition.getName()!=null && !"".equals(condition.getName().trim())){
				//System.out.println("进来了 condition.getName()");
				//System.out.println("name:"+ condition.getName());
				
				/**
				 * Mybatis自动生成的查询selectByExample(TExample example) 中like需要自己写通配符
				 */
				criteria.andNameLike("%" + condition.getName() + "%"); 
			}
			// 主办者
			if(condition.getSponsorName()!=null && !"".equals(condition.getSponsorName().trim())){
				criteria.andSponsorNameLike("%" + condition.getSponsorName() + "%");
			}
			// 赛事亮点
			if(condition.getEdge()!=null && !"".equals(condition.getEdge().trim())){
				criteria.andEdgeLike("%" + condition.getEdge() + "%");
			}
			// 状态
			if(condition.getStatusStr()!=null && !"".equals(condition.getStatusStr().trim()) && status != 5){
				criteria.andStatusEqualTo(status);
			}
			// 开始时间
			if( condition.getStartDate1()!=null && !"".equals(condition.getStartDate1().trim()) && condition.getStartDate2()!=null && !"".equals(condition.getStartDate2().trim()) ){
				criteria.andStartDateBetween(startDateValue1, startDateValue2);
			}
		}
		
		List<Game> list = gameMapper.selectByExample(example);
		
		
		/**
		 * 因为 Game 类型 的数据，里面的 status 属性 的值 是  0,1,2,3,4,5 ，不应该把这种值 显示到 页面上（其他属性也有类似问题），
		 * 所以 在 Game 基础上 再封装一个类 DisplayGamesTable ，用于显示在 页面上。
		 */
		List<DisplayGamesTable> displayList = PojoConvertUtils.GameConvertDisplay(list);
		
		System.out.println("displayList:"+displayList);
		
		/**
		 * PageInfo 里面有 分页信息，在下面 用到的 分页信息 只有 总记录数。
		 * 因为 前面 分页插件PageInfo 是对 List<Game> 分页，而不是 对 List<DisplayGamesTable> 分页，
		 * 所以 要取得 分页信息 ，PageInfo 的参数 还是要用 List<Game>，List<DisplayGamesTable> 只是在 List<Game> 基础上 再封装一层实体 而已。
		 */
		PageInfo<Game> pageInfo = new PageInfo<>(list);
		
		LayuiTableData layuiTableData = new LayuiTableData();
		layuiTableData.setCode(0);
		layuiTableData.setMsg("");
		layuiTableData.setCount(pageInfo.getTotal());
		layuiTableData.setData(displayList);
		
		System.out.println("layuiTableData:"+layuiTableData);
		
		return layuiTableData;
	}

	/**
	 * 根据赛事名称，查找赛事；赛事名称 有 唯一约束
	 */
	@Override
	public List<Game> getGamesByName(String gameName) {
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(gameName);
		/**
		 * 在数据库中， game表 的descr字段 是 text 大文本类型。
		 * mybatis对text类型进行了特别处理，在selectByExampleWithBLOBs里面，criteria里面没有。但可以自己在example里面自己写，他会自动映射成sql语句进行查询
		 */
		//List<Game> list = gameMapper.selectByExample(example);
		List<Game> list = gameMapper.selectByExampleWithBLOBs(example);
		
		System.out.println("getGamesByName_list:"+list);
		
		return list;
	}

	/**
	 * 根据 id 查找 赛事
	 */
	@Override
	public Game getGameById(String gameId) {
		
		Game game = gameMapper.selectByPrimaryKey(gameId);
		
		return game;
	}

}
