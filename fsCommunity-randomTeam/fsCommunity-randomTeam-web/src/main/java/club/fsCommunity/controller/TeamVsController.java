package club.fsCommunity.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.service.GameService;
import club.fsCommunity.service.TeamService;
import club.fsCommunity.service.TeamVsService;

@Controller
@RequestMapping("/teamVs")
public class TeamVsController {
	
	@Autowired
	private TeamVsService teamVsService;
	
	@Autowired
	private GameService gameService;
	
	
	
	
	@RequestMapping(value = {"/selectAllTeamVsByGameId/{gameId}"}, method = {RequestMethod.GET})
	@ResponseBody
	public LayuiTableData selectAllTeamVsByGameId(
			@PathVariable("gameId") String gameId,
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit){
		
		System.out.println("selectAllTeamVsByGameId 方法");
		
		LayuiTableData data = teamVsService.selectAllTeamVsByGameId(gameId, page, limit);
		
		return data;
		
	}
	
	
	@RequestMapping("/toteamVs")
	public String toteamVs(@RequestParam("gameId") String gameId,Model model){
		
		System.out.println("toteamVs 方法 _ gameId" + gameId);
		
		Game game = gameService.getGameByGameId(gameId);
		model.addAttribute("game", game);
		return "game/teamVs";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
