package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import club.fsCommunity.pojo.Game;

public interface GameService {

	int addGame(Game game);
	
	List<Game> getLaunchGameByUserId(String userId); // 查询某个用户 发起的 所有赛事
	
	List<Game> getEnrollGameByUserId(String userId); // 查询某个用户 报名的 所有赛事
	
	Game getGameByGameId(String gameId); // 通过 赛事id 查找 赛事
	
	// 取消赛事（把 赛事 状态 改为 4）
	Map<String,Object> cancelGame(String gameId);
	
	// 赛事报名人数+1
	Map<String,Object> applyCountAddOne(String gameId);
	
	// 更新 赛事 分组状态
	Map<String,Object> updateGroupStatus(String gameId);
	
	// 查询最近一个星期发起 的赛事（只查找 状态为0、1的）
	List<Game> selectAllGamesLastWeek();
	
	
	
	
}
