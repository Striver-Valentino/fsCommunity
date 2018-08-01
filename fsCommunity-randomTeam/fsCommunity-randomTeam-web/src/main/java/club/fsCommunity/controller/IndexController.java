package club.fsCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.service.GameService;
import club.fsCommunity.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private GameService gameService;
	
	
	//@RequestMapping("/")
	public String showIndexTest(){
		return "indexTest";
	}
	
	
	@RequestMapping("/")
	public String showIndex(Model model){
		List<Game> list = gameService.selectAllGamesLastWeek();
		
		model.addAttribute("gameList", list);
		
		return "index";
	}
	
	
	
	@RequestMapping("/initwebsiteIntroduction")
	public String initwebsiteIntroduction(Model model){
		
		return "other/websiteIntroduction";
	}
	
	
	
	@RequestMapping("/inittermsOfService")
	public String inittermsOfService(Model model){
		
		return "other/termsOfService";
	}
	
	
	
	
	
	
	
	
	
	
	

}
