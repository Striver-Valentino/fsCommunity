package club.fsCommunity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.GameExample.Criteria;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.LaunchGameService;

@Service
public class LaunchGameServiceImpl implements LaunchGameService {

	@Autowired
	private GameMapper gameMapper;
	
	@Override
	public Map<String,Object> addOneGame(Game game) {
		
		System.out.println("LaunchGameService game:"+game);
		
		Map<String,Object> map = new HashMap<>();
		
		if( StringUtils.isBlank(game.getName()) ){
			map.put("msgGameName", "赛事名称不能为空");
			return map;
		}
		
		Game game2 = this.selectGameByName(game.getName());
		if(game2 != null){
			map.put("msgGameName", "您填写的赛事名称已经被使用");
			return map;
		}
		
		
		// 通过以上验证，就可以开始 添加 赛事了。
		
		game.setId(randomNumberUtil.generateGameID());
		game.setApplyCount(0);
		game.setStatus(0);
		game.setLaunchDate(new Date());
		
		gameMapper.insert(game);
		
		System.out.println("addOneGame:"+game);
		
		map.put("launchSuccess", "赛事发起成功");
		
		return map;
	}

	
	
	/**
	 * 通过 赛事名称  查找 赛事
	 */
	@Override
	public Game selectGameByName(String name) {
		
		Game game = null;
		
		GameExample example = new GameExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		
		List<Game> list = gameMapper.selectByExample(example);
		
		for (Game game2 : list) {
			if( name.equals(game2.getName()) ){
				game = game2;
			}
		}
		
		return game;
	}

}
