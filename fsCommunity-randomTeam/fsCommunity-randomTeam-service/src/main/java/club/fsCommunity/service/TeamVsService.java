package club.fsCommunity.service;

import java.util.Map;

import club.fsCommunity.common.pojo.LayuiTableData;

public interface TeamVsService {
	
	Map<String,Object> addTeamVs(String team1Id,String team2Id,String gameId);
	
	LayuiTableData selectAllTeamVsByGameId(String gameId,Integer page,Integer limit);

}
