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

	
	
	@Override
	public LayuiTableData getGamesByCondition(Integer page,Integer limit,ConditionOfSelectGames condition) {
		
		System.out.println("SignUpGameServiceImpl_condition:" + condition);
		
		int status = 0;
		Date startDateValue1 = null;
		Date startDateValue2 = null;
		
		if(condition != null){
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
		
		
		PageHelper.startPage(page, limit);
		
		GameExample example = new GameExample();
		
		Criteria criteria = example.createCriteria();
		
		if(condition!=null){
			if(condition.getName()!=null && !"".equals(condition.getName().trim())){
				
				
				criteria.andNameLike("%" + condition.getName() + "%"); 
			}
			if(condition.getSponsorName()!=null && !"".equals(condition.getSponsorName().trim())){
				criteria.andSponsorNameLike("%" + condition.getSponsorName() + "%");
			}
			if(condition.getEdge()!=null && !"".equals(condition.getEdge().trim())){
				criteria.andEdgeLike("%" + condition.getEdge() + "%");
			}
			if(condition.getStatusStr()!=null && !"".equals(condition.getStatusStr().trim()) && status != 5){
				criteria.andStatusEqualTo(status);
			}
			if( condition.getStartDate1()!=null && !"".equals(condition.getStartDate1().trim()) && condition.getStartDate2()!=null && !"".equals(condition.getStartDate2().trim()) ){
				criteria.andStartDateBetween(startDateValue1, startDateValue2);
			}
		}
		
		List<Game> list = gameMapper.selectByExample(example);
		
		
		
		List<DisplayGamesTable> displayList = PojoConvertUtils.GameConvertDisplay(list);
		
		System.out.println("displayList:"+displayList);
		
		
		PageInfo<Game> pageInfo = new PageInfo<>(list);
		
		LayuiTableData layuiTableData = new LayuiTableData();
		layuiTableData.setCode(0);
		layuiTableData.setMsg("");
		layuiTableData.setCount(pageInfo.getTotal());
		layuiTableData.setData(displayList);
		
		System.out.println("layuiTableData:"+layuiTableData);
		
		return layuiTableData;
	}

	
	@Override
	public List<Game> getGamesByName(String gameName) {
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(gameName);
		
		List<Game> list = gameMapper.selectByExampleWithBLOBs(example);
		
		System.out.println("getGamesByName_list:"+list);
		
		return list;
	}

	
	@Override
	public Game getGameById(String gameId) {
		
		Game game = gameMapper.selectByPrimaryKey(gameId);
		
		return game;
	}

}
