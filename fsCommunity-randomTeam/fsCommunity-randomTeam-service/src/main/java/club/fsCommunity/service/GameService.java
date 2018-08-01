package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import club.fsCommunity.pojo.Game;

public interface GameService {

	int addGame(Game game);
	
	List<Game> getLaunchGameByUserId(String userId);
	
	List<Game> getEnrollGameByUserId(String userId);
	
	Game getGameByGameId(String gameId); 
	
	Map<String,Object> cancelGame(String gameId);
	
	Map<String,Object> applyCountAddOne(String gameId);
	
	Map<String,Object> updateGroupStatus(String gameId);
	
	List<Game> selectAllGamesLastWeek();
	
	
	
	
}
