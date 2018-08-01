package club.fsCommunity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.fsCommunity.pojo.Game;
import club.fsCommunity.service.GameService;


@Controller
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	
	
	@RequestMapping(value = {"/initOrganizeGame/{gameId}"})
	public String initOrganizeGame(@PathVariable("gameId") String gameId,Model model){
		Game game = gameService.getGameByGameId(gameId);
		model.addAttribute("game", game);
		return "game/organizeGame";
	}
	
	
	@RequestMapping("/cancelGame")
	public String cancelGame(@RequestParam("gameId") String gameId,Model model){
		
		System.out.println("cancelGame方法");
		
		Map<String, Object> map = gameService.cancelGame(gameId);
		
		if(map.containsKey("cancelGameSuc")){
			System.out.println("cancelGame方法:取消了赛事");
			model.addAttribute("cancelGameOK", (String)map.get("cancelGameSuc"));
			
			return "forward:/user/initUserIndex";
			
		}else{
			model.addAttribute("cancelGameError", (String)map.get("cancelGameError"));
			
			return "forward:/user/initUserIndex";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
