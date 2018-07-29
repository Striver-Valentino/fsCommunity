package club.fsCommunity.service;

import java.util.List;

import club.fsCommunity.common.pojo.ConditionOfSelectGames;
import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Game;

public interface SignUpGameService {

	LayuiTableData getGamesByCondition(Integer page,Integer limit,ConditionOfSelectGames condition);
	
	List<Game> getGamesByName(String gameName);
	
	// 根据 id 查找 赛事 
	Game getGameById(String gameId);
	
}
