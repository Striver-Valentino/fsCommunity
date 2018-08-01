package club.fsCommunity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.mapper.TeamMapper;
import club.fsCommunity.mapper.TeamVsMapper;
import club.fsCommunity.pojo.Team;
import club.fsCommunity.pojo.TeamExample;
import club.fsCommunity.pojo.TeamVs;
import club.fsCommunity.pojo.TeamVsExample;
import club.fsCommunity.pojo.TeamVsExample.Criteria;
import club.fsCommunity.service.TeamService;
import club.fsCommunity.service.TeamVsService;

@Service
public class TeamVsServiceImpl implements TeamVsService {
	
	@Autowired
	private TeamVsMapper teamVsMapper;
	
	@Autowired
	private TeamService teamService;
	
	

	
	@Override
	public Map<String, Object> addTeamVs(String team1Id,String team2Id,String gameId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		TeamVs teamVs = new TeamVs();
		
		teamVs.setTeamVsId(randomNumberUtil.generateTeamVsID());
		teamVs.setGameId(gameId);
		teamVs.setStatus(0);
		teamVs.setTeam1Id(team1Id);
		teamVs.setTeam2Id(team2Id);
		teamVs.setVsSign("VS");
		
		Team team1 = teamService.selectTeamByTeamId(team1Id).get(0);
		Team team2 = teamService.selectTeamByTeamId(team2Id).get(0);
		teamVs.setName(
				team1.getName() + "(" + team1.getLineup() + ")" + "  VS  " + team2.getName() + "(" + team2.getLineup() + ")"
		);
		
		teamVs.setTeam1Name(team1.getName());
		teamVs.setTeam1Lineup(team1.getLineup());
		teamVs.setTeam2Name(team2.getName());
		teamVs.setTeam2Lineup(team2.getLineup());
		
		teamVsMapper.insert(teamVs);
		
		map.put("addTeamVsSuc", "addTeamVsSuc");
		
		return map;
	}



	
	@Override
	public LayuiTableData selectAllTeamVsByGameId(String gameId, Integer page,
			Integer limit) {
		
		PageHelper.startPage(page, limit);
		
		TeamVsExample example = new TeamVsExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameIdEqualTo(gameId);
		List<TeamVs> list = teamVsMapper.selectByExampleWithBLOBs(example);
		
		PageInfo<TeamVs> pageInfo = new PageInfo<TeamVs>(list);
		
		LayuiTableData data = new LayuiTableData();
		data.setCode(0);
		data.setMsg("");
		data.setCount(pageInfo.getTotal());
		data.setData(list);

		return data;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
