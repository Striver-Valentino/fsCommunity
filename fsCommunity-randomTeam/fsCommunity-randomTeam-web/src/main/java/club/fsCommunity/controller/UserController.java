package club.fsCommunity.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.fsCommunity.common.utils.JsonUtil;
import club.fsCommunity.common.utils.ValidateCodeUtils;
import club.fsCommunity.model.HostHolder;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.Game;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.EnrollService;
import club.fsCommunity.service.GameService;
import club.fsCommunity.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private EnrollService enrollService;
	
	@Autowired
	private HostHolder hostHolder;
	
	@Autowired
	private UserService userService;
	
	

	
	@RequestMapping("/initUserIndex")
	public String initUserIndex(@RequestParam(value="Enrollok",defaultValue="") String Enrollok,Model model){
		
		System.out.println("Enrollok:"+Enrollok);
		model.addAttribute("Enrollok", Enrollok);
		
		System.out.println("initUserIndex 当前用户id:" + hostHolder.getUser().getId());
		List<Game> launchGameList = gameService.getLaunchGameByUserId(hostHolder.getUser().getId());
		List<Enroll> enrollList = enrollService.selectEnrollByUserId(hostHolder.getUser().getId());
		
		System.out.println("launchGameList:" + launchGameList);
		System.out.println("enrollList:" + enrollList);
		
		model.addAttribute("launchGameList",launchGameList);
		model.addAttribute("enrollList",enrollList);
		
		return "user/userGame";
	}
	
	
	@RequestMapping("/initUserSet")
	public String initUserSet(@RequestParam(value="updateOK2",defaultValue="") String updateOK2,Model model){
		System.out.println("updateOK2:"+updateOK2);
		model.addAttribute("updateOK2", updateOK2);
		
		return "user/setGameName";
	}
	
	
	@RequestMapping("/updateUserGameName")
	public String updateUserGameName(User user,Model model,String userId){
		
		System.out.println("updateUserGameName");
		
		user.setId(userId);
		
		Map<String, Object> map = userService.updateUserGameName(user);
		
		if(map.containsKey("updateUserGameNameSuc")){
			System.out.println("修改游戏昵称成功");
			
			model.addAttribute("updateOK", "updateOK");
			
			return "user/setGameName";
			
		}else{
			System.out.println("修改游戏昵称出错");
			model.addAttribute("updateGameNameError", (String)map.get("msgGameName"));
			
			return "user/setGameName";
		}
		
	}
	
	
	@RequestMapping("/updateUserHeadUrl")
	public String updateUserHeadUrl(User user,Model model,String userId){
		
		System.out.println("updateUserHeadUrl");
		
		user.setId(userId);
		
		Map<String, Object> map = userService.updateUserHeadUrl(user);
		
		if(map.containsKey("updateUserHeadUrlSuc")){
			System.out.println("修改头像成功");
			
			model.addAttribute("updateOK", "updateOK");
			
			return "user/setHearUrl";
			
		}else{
			System.out.println("修改头像出错");
			model.addAttribute("updateHeadUrlError", (String)map.get("msgHeadUrl"));
			
			return "user/setHearUrl";
		}
		
	}
	
	
	@RequestMapping("/updateUserPassword")
	public String updateUserPassword(String userId,String oldPwd, String newPwd,String confirmPwd,Model model){
		
		System.out.println("updateUserPassword");
		System.out.println("oldPwd:" + oldPwd);
		System.out.println("newPwd:" + newPwd);
		System.out.println("confirmPwd:" + confirmPwd);
		
		Map<String, Object> map = userService.updateUserPassword(userId, oldPwd, newPwd, confirmPwd);
		
		if(map.containsKey("updateUserPasswordSuc")){
			System.out.println("修改密码成功");
			
			model.addAttribute("updateOK", "updateOK");
			
			return "user/setRePass";
			
		}else{
			System.out.println("修改密码出错");
			model.addAttribute("updatePasswordError", (String)map.get("msgpwd"));
			
			return "user/setRePass";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
