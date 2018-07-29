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
	
	/**
	 * 跳转到首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(Model model){
		List<Game> list = gameService.selectAllGamesLastWeek();
		
		model.addAttribute("gameList", list);
		
		return "index";
	}
	
	
	/**
	 * 跳转到 网站简介页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/initwebsiteIntroduction")
	public String initwebsiteIntroduction(Model model){
		
		return "other/websiteIntroduction";
	}
	
	
	/**
	 * 跳转到 用户服务条款 页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/inittermsOfService")
	public String inittermsOfService(Model model){
		
		return "other/termsOfService";
	}
	
	
	
	
	
	
	
	
	
	
	

}
