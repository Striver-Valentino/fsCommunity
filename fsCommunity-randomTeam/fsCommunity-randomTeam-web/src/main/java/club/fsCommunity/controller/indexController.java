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
import club.fsCommunity.service.indexService;

@Controller
public class indexController {
	
	@Autowired
	private indexService indexService;
	
	//@RequestMapping("/")
	public String showIndexTest(){
		return "indexTest";
	}
	
	@RequestMapping("/")
	public String showIndex(Model model){
		return "index";
	}
	
	@RequestMapping("/showAllGames")
	@ResponseBody
	public LayuiTableData showAllGames(Model model,
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit){
		
		LayuiTableData data = indexService.showAllGames(page,limit);
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
