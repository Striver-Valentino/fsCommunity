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

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private GameService gameService;
	
	
	/**
	 * 开始分组
	 * @param gameId
	 * @param model
	 * @return
	 */
	@RequestMapping("/startGroup")
	public String startGroup(@RequestParam("gameId") String gameId,Model model){
		
		System.out.println("startGroup方法_gameId:" + gameId);
		
		Game game = gameService.getGameByGameId(gameId);
		
		Map<String, Object> map = teamService.startGroup(gameId);
		
		if(map.containsKey("startGroupSuc")){
			
			model.addAttribute("startGroupOK", (String)map.get("startGroupSuc"));
			model.addAttribute("game", game);
			return "game/teamVs";
			
		}else{
			
			model.addAttribute("startGroupError", (String)map.get("groupError"));
			return "game/organizeGame";
		}
		
	}
	
	
	/**
	 * 查询所有的队伍
	 * @param gameId
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = {"/selectAllTeamByGameId/{gameId}"}, method = {RequestMethod.GET})
	@ResponseBody
	public LayuiTableData selectAllTeamByGameId(
			@PathVariable("gameId") String gameId,
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit){
		
		System.out.println("selectAllTeamByGameId 方法");
		
		LayuiTableData data = teamService.selectAllTeamByGameId(gameId, page, limit);
		
		return data;
		
	}
	
	// 测试URL
	@RequestMapping("/testUrl")
	public String testUrl(@RequestParam("hello") String hello){
		
		System.out.println("hello:" + hello);
		System.out.println("测试URL");
		
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
