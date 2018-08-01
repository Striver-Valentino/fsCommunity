package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Team;

public interface TeamService {

	Map<String, Object> addTeam(String userIdMember1,String userIdMember2,String userIdMember3,String lineup,String gameId);
	
	Map<String, Object> startGroup(String gameId);
	
	LayuiTableData selectAllTeamByGameId(String gameId,Integer page,Integer limit);
	
	List<Team> selectTeamByTeamId(String teamId);
	
	
	
	
	
	
	
	
	
}
