package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Team;

public interface TeamService {

	// 增加一支队伍
	Map<String, Object> addTeam(String userIdMember1,String userIdMember2,String userIdMember3,String lineup,String gameId);
	
	// 开始分组
	Map<String, Object> startGroup(String gameId);
	
	// 查询 一个赛事的 所有 队伍
	LayuiTableData selectAllTeamByGameId(String gameId,Integer page,Integer limit);
	
	// 根据 队伍id 查询 队伍
	List<Team> selectTeamByTeamId(String teamId);
	
	
	
	
	
	
	
	
	
}
