package club.fsCommunity.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.fsCommunity.common.utils.JsonUtil;
import club.fsCommunity.model.HostHolder;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.LaunchGameService;


@Controller
public class LaunchGameController {

	@Autowired
	private LaunchGameService launchGameService;
	
	@Autowired
	private HostHolder hostHolder;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping("/initLaunch")
	public String initLaunch(){
		return "launchGame";
	}
	
	@RequestMapping("/launchGame")
	public String launchGame(Game game,HttpSession session,Model model,
			        @RequestParam("startDate1") String startDate,
			        @RequestParam("endDate1") String endDate,
			        @RequestParam("signUpLine1") String signUpLine,
			        HttpServletResponse response){
		
		System.out.println("LaunchGameController_launchGame:" + game);
		
		System.out.println("startDate1:" + startDate);
		System.out.println("endDate1:" + endDate);
		System.out.println("signUpLine1:" + signUpLine);
		
		try {
			game.setStartDate(sdf.parse(startDate));
			game.setEndDate(sdf.parse(endDate));
			game.setSignUpLine(sdf.parse(signUpLine));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User loginUser1 = (User)session.getAttribute("loginUser");
		User loginUser = hostHolder.getUser();
		System.out.println("launchGame_loginUser:" + loginUser);
		System.out.println("launchGame_game:" + game);
		game.setLaunchUserId(loginUser.getId());
		game.setLaunchUserName(loginUser.getGameName()); 
		
		Map<String, Object> map = launchGameService.addOneGame(game);
		
		if(map.containsKey("launchSuccess")){
			
			model.addAttribute("launchSuc", "发起赛事成功");
			
			return "searchGame";
		}else{
			model.addAttribute("launchError", JsonUtil.getJSONString(1, map));
			
			return "launchGame";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
