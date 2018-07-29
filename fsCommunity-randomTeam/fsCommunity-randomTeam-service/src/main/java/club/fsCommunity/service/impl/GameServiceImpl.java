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

	/**
	 * 查询某个用户 发起的 所有赛事
	 */
	@Override
	public List<Game> getLaunchGameByUserId(String userId) {
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andLaunchUserIdEqualTo(userId);  //  根据 发起者 id 查找
		criteria.andStatusNotEqualTo(4); // 不显示 已取消 的 赛事
		
		example.setOrderByClause("`launch_date` DESC,`name` DESC");
		
		List<Game> list = gameMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	/**
	 * 查询某个用户 报名的 所有赛事
	 */
	@Override
	public List<Game> getEnrollGameByUserId(String userId) {
		
		// 现找到 用户 所有的报名信息 实体，然后 从里面 获取 报名 的 赛事id
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

	/**
	 * 通过 赛事id 查找 赛事
	 */
	@Override
	public Game getGameByGameId(String gameId) {
		Game game = gameMapper.selectByPrimaryKey(gameId);
		return game;
	}

	/**
	 * 取消赛事（把 赛事 状态 改为 4）
	 */
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

	/**
	 * 赛事 报名人数  +1
	 */
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

	/**
	 * 更新 赛事 分组状态，改为1
	 */
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

	/**
	 * 查询最近一个星期发起的赛事（只查找 状态为0、1的）
	 */
	@Override
	public List<Game> selectAllGamesLastWeek() {
		Date date = new Date();
		
		GameExample example = new GameExample();
		Criteria criteria1 = example.createCriteria();
		criteria1.andStatusEqualTo(0);
		criteria1.andLaunchDateBetween(GeneralUtils.callLastTime(date, -7), date); // 7天前，到现在 为止
		
		Criteria criteria2 = example.createCriteria();
		criteria2.andStatusEqualTo(1);
		criteria1.andLaunchDateBetween(GeneralUtils.callLastTime(date, -7), date); // 7天前，到现在 为止
		
		example.or(criteria2);
		
		example.setOrderByClause("`start_date` DESC,`name` DESC");
		
		List<Game> list = gameMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
