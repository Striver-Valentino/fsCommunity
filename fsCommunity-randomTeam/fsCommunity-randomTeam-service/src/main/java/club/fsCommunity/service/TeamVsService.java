package club.fsCommunity.service;

import java.util.Map;

import club.fsCommunity.common.pojo.LayuiTableData;

public interface TeamVsService {
	
	// 添加一组对阵
	Map<String,Object> addTeamVs(String team1Id,String team2Id,String gameId);
	
	// 查询 一个赛事的 所有 对阵情况
	LayuiTableData selectAllTeamVsByGameId(String gameId,Integer page,Integer limit);

}
