package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.Game;

public interface LaunchGameService {

	/**
	 * 添加一个赛事
	 * @param game
	 * @return
	 */
	Map<String,Object> addOneGame(Game game);
	
	Game selectGameByName(String name);
	
	
	
	
	
	
	
	
}
