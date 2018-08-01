package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.Game;

public interface LaunchGameService {

	Map<String,Object> addOneGame(Game game);
	
	Game selectGameByName(String name);
	
	
	
	
	
	
	
	
}
