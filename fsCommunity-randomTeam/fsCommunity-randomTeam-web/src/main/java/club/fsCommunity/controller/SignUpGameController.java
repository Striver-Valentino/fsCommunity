package club.fsCommunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.fsCommunity.common.pojo.ConditionOfSelectGames;
import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.common.utils.PojoConvertUtils;
import club.fsCommunity.mapper.GameMapper;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.GameExample;
import club.fsCommunity.pojo.GameExample.Criteria;
import club.fsCommunity.service.SignUpGameService;
import club.fsCommunity.service.IndexService;


@Controller
public class SignUpGameController {
	
	@Autowired
	private SignUpGameService signUpGameService;
	
	@Autowired
	private GameMapper gameMapper;
	
	@RequestMapping("/initSignUpDetails")
	public String initSignUpDetails(Model model){
		return "signUpDetails"; 
	}
	
	@RequestMapping("/toSearchGame")
	public String toSearchGame(Model model){
		return "searchGame";
	}
	
	@RequestMapping(value="/initSignUpGame",produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
	public String initSignUpGame(Model model,@RequestParam("gameName") String gameName){
		System.out.println("进入了方法：initSignUpGame");
		System.out.println("SignUpGameController_gameName:"+gameName);
		
		List<Game> list = signUpGameService.getGamesByName(gameName);
		System.out.println("转换前的game:"+list.get(0));
		System.out.println("转换后的game:"+PojoConvertUtils.GameConvertDisplay(list).get(0));
		
		Game game = list.get(0);
		
		return "redirect:/signUpGame/" + game.getId(); 
	}
	
	
	@RequestMapping(value = {"/signUpGame/{gameId}"}, method = {RequestMethod.GET})
	public String signUpGameByGameId(@PathVariable("gameId") String gameId,Model model){
		
		System.out.println("signUpGameByGameId_gameId:" + gameId);
		
		Game game = signUpGameService.getGameById(gameId);
		model.addAttribute("game",game);
		model.addAttribute("gameId",gameId);
		
		return "signUpGame";
		
	}
	
	
	@RequestMapping("/showGamesByCondition")
	@ResponseBody
	public LayuiTableData showGamesByCondition(Model model,
			ConditionOfSelectGames condition,
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit){
		
		System.out.println("SignUpGameController_condition:"+condition);
		
		LayuiTableData data = signUpGameService.getGamesByCondition(page,limit,condition);
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
