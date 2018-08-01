package club.fsCommunity.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.mapper.EnrollMapper;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.GameExample.Criteria;
import club.fsCommunity.service.EnrollService;
import club.fsCommunity.service.GameService;

@Service("GameService")
public class GameServiceImpl implements GameService {

	@Autowired
	private GameMapper gameMapper;
	
	@Autowired
	private EnrollService enrollService;
	
	@Override
	public int addGame(Game game) {
		return gameMapper.insert(game);
	}

	
	@Override
	public List<Game> getLaunchGameByUserId(String userId) {
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andLaunchUserIdEqualTo(userId);
		criteria.andStatusNotEqualTo(4);
		
		example.setOrderByClause("`launch_date` DESC,`name` DESC");
		
		List<Game> list = gameMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	
	@Override
	public List<Game> getEnrollGameByUserId(String userId) {
		
		List<Enroll> list = enrollService.selectEnrollByUserId(userId);
		
		System.out.println("getEnrollGameByUserId - list:" + list);
		
		List<Game> gameList = new ArrayList<Game>();
		
		for (Enroll enroll : list) {
			Game game = getGameByGameId(enroll.getGameId());
			System.out.println("enroll.getGameId():" + enroll.getGameId());
			System.out.println("game:" + game);
			
			if(game == null){
				continue;
			}
			
			gameList.add(game);
		}
		
		System.out.println("getEnrollGameByUserId - gameList:" + gameList);
		
		return gameList;
	}

	
	@Override
	public Game getGameByGameId(String gameId) {
		Game game = gameMapper.selectByPrimaryKey(gameId);
		return game;
	}

	
	@Override
	public Map<String, Object> cancelGame(String gameId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		if(gameId == null || "".equals(gameId)){
			map.put("cancelGameError", "你要取消的赛事不存在");
			return map;
		}
		
		Game game2 = gameMapper.selectByPrimaryKey(gameId);
		if(game2 == null){
			map.put("cancelGameError", "你要取消的赛事不存在");
			return map;
		}
		
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(gameId);
		
		Game game = new Game();
		game.setStatus(4);
		
		gameMapper.updateByExampleSelective(game, example);
		
		map.put("cancelGameSuc", "赛事已取消");
		return map;
	}

	
	@Override
	public Map<String, Object> applyCountAddOne(String gameId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		if(gameId == null || "".equals(gameId)){
			map.put("applyCountAddOneError", "你要报名的赛事不存在");
			return map;
		}
		
		Game game2 = gameMapper.selectByPrimaryKey(gameId);
		if(game2 == null){
			map.put("applyCountAddOneError", "你要报名的赛事不存在");
			return map;
		}
		
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(gameId);
		
		Game game = new Game();
		game.setApplyCount(game2.getApplyCount() + 1);
		
		gameMapper.updateByExampleSelective(game, example);
		
		map.put("applyCountAddOneSuc", "赛事报名人数已经+1");
		return map;
	}

	
	@Override
	public Map<String, Object> updateGroupStatus(String gameId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		if(gameId == null || "".equals(gameId)){
			map.put("updateGroupStatusError", "你要 更新分组状态 的赛事不存在");
			return map;
		}
		
		Game game2 = gameMapper.selectByPrimaryKey(gameId);
		if(game2 == null){
			map.put("updateGroupStatusError", "你要 更新分组状态 的赛事不存在");
			return map;
		}
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(gameId);
		
		Game game = new Game();
		game.setGroupStatus(1);
		
		gameMapper.updateByExampleSelective(game, example);
		
		map.put("updateGroupStatusSuc", "更新 赛事 分组状态 成功");
		
		return map;
	}

	
	@Override
	public List<Game> selectAllGamesLastWeek() {
		Date date = new Date();
		
		GameExample example = new GameExample();
		Criteria criteria1 = example.createCriteria();
		criteria1.andStatusEqualTo(0);
		criteria1.andLaunchDateBetween(GeneralUtils.callLastTime(date, -7), date); 
		
		Criteria criteria2 = example.createCriteria();
		criteria2.andStatusEqualTo(1);
		criteria1.andLaunchDateBetween(GeneralUtils.callLastTime(date, -7), date); 
		
		example.or(criteria2);
		
		example.setOrderByClause("`start_date` DESC,`name` DESC");
		
		List<Game> list = gameMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
