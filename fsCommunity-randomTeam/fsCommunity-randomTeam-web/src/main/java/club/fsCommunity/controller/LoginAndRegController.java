package club.fsCommunity.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventProducer;
import club.fsCommunity.async.EventType;
import club.fsCommunity.common.utils.JsonUtil;
import club.fsCommunity.common.utils.ValidateCodeUtils;
import club.fsCommunity.model.HostHolder;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.CloudService;
import club.fsCommunity.service.UserService;

@Controller
public class LoginAndRegController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CloudService cloudService;
	
	@Autowired
	private EventProducer eventProducer;
	
	@Autowired
	private HostHolder hostHolder;
	
	
	
	@RequestMapping("/initreg")
	public String initreg(){
		return "reg";
	}
	
	@RequestMapping("/initlogin")
	public String initlogin(){
		return "login";
	}
	
	@RequestMapping("/imageCode")
	@ResponseBody
	public String imageCode(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(true);
		
		try {
			
			ServletOutputStream out = response.getOutputStream();
			String sCode = ValidateCodeUtils.genNewCode(out);
			
			session.setAttribute("sCode", sCode);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	@RequestMapping("/uploadImage")
	@ResponseBody
	public Map<Object,Object> uploadImage(MultipartFile file){
		String imageUrl = null;
		Map<Object,Object> map = new HashMap<Object,Object>();
		try {
			imageUrl = cloudService.saveImage(file);
			
			if(imageUrl == null){
				map.put("code", 1); 
				map.put("imageUrl", imageUrl);
			}
			
			map.put("code", 0); 
			map.put("imageUrl", imageUrl);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping("/reg")
	public String reg(@RequestParam("vercode") String vercode,
						User user,
						HttpServletRequest request,
						Model model,
						HttpServletResponse response){
		
		System.out.println("regUser:" + user);
		System.out.println("regVercode:" + vercode);
		
		HttpSession session = request.getSession(false); 
		if(session != null){
			String sCode = (String)session.getAttribute("sCode");
			
			if(!vercode.trim().equals(sCode.trim())){
				model.addAttribute("msgvercode", "验证码错误");
				return "reg";
			}
		}
		
		
		String ipAddress = getIpAddress(request);
		user.setLastLoginIp(ipAddress);
		System.out.println("ipAddress:"+ipAddress);
		
		Map<String, Object> map = userService.registerUser(user);
		
		if(map.containsKey("clubfsticket")){
			Cookie cookie = new Cookie("clubfsticket", map.get("clubfsticket").toString());
			
			cookie.setPath("/");
			cookie.setMaxAge(30*3600);
			
			response.addCookie(cookie);
			
			
			Cookie cookieSession = new Cookie("JSESSIONID", session.getId());
			System.out.println("Reg_JSESSIONID:" + session.getId());
			
			cookieSession.setPath("/");
			cookieSession.setMaxAge(30*3600); 
			
			response.addCookie(cookieSession);
			
			
			if(map.containsKey("user")){
				session.setAttribute("loginUser", (User)map.get("user"));
				hostHolder.setUser((User)map.get("user"));
			}
			
			model.addAttribute("regsuc", JsonUtil.getJSONString(0, "注册成功"));
			model.addAttribute("regSucPleaseAct", "您已注册成功，请到注册邮箱点击链接激活用户");
			
			
			
			eventProducer.fireEvent(new EventModel(EventType.REG)
					.setActorId( ((User)map.get("user")).getId() )
					.setExt( "username", ((User)map.get("user")).getGameName() )
					.setExt( "email", ((User)map.get("user")).getEmail() )
					.setExt("activeCode", ((User)map.get("user")).getActiveCode()) 
			);
			
			
			
			return "other/notice";
			
		}else{
			model.addAttribute("regerror", JsonUtil.getJSONString(1, map));
			
			return "reg";
		}
		
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("vercode") String vercode,
						User user,
						HttpServletRequest request,
						Model model,
						HttpServletResponse response){
		
		System.out.println("loginUser:" + user);
		System.out.println("loginVercode:" + vercode);
		
		HttpSession session = request.getSession(false); 
		if(session != null){
			String sCode = (String)session.getAttribute("sCode");
			
			if(!vercode.trim().equals(sCode.trim())){
				model.addAttribute("msgvercode", "验证码错误");
				return "login";
			}
		}
		
		String ipAddress = getIpAddress(request);
		user.setLastLoginIp(ipAddress);
		System.out.println("ipAddress:"+ipAddress);
		
		Map<String, Object> map = userService.loginUser(user);
		
		if(map.containsKey("clubfsticket")){
			Cookie cookie = new Cookie("clubfsticket", map.get("clubfsticket").toString());
			
			cookie.setPath("/");
			cookie.setMaxAge(30*3600);
			
			response.addCookie(cookie);
			
			
			Cookie cookieSession = new Cookie("JSESSIONID", session.getId());
			System.out.println("JSESSIONID:" + session.getId());
			
			cookieSession.setPath("/");
			cookieSession.setMaxAge(30*3600); 
			
			response.addCookie(cookieSession);
			
			
			if(map.containsKey("user")){
				session.setAttribute("loginUser", (User)map.get("user"));
				hostHolder.setUser((User)map.get("user"));
			}
			
			model.addAttribute("loginsuc", JsonUtil.getJSONString(0, "登录成功"));
			
			
			
			eventProducer.fireEvent(new EventModel(EventType.LOGIN)
					.setActorId( ((User)map.get("user")).getId() )
					.setExt( "username", ((User)map.get("user")).getGameName() )
					.setExt( "email", ((User)map.get("user")).getEmail() )
			);
			
			return "forward:/";
		}else{
			model.addAttribute("loginerror", JsonUtil.getJSONString(1, map));
			
			return "login";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(@CookieValue("clubfsticket") String ticket,
			             HttpServletRequest request){
		
		userService.logout(ticket);
		
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute("loginUser");
			System.out.println(session.getAttribute("loginUser"));
		}
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/regActive")
	public String regActive(@RequestParam("email") String email,@RequestParam("activeCode") String activeCode,Model model){
		
		Map<String, Object> map = userService.regActive(email, activeCode);

		if(map.containsKey("actSuc")){
			
			User user = userService.selectUserByEmail(email); 
			user.setActiveDate(new Date());
			
			model.addAttribute("regActSuc", "激活成功");
			return "forward:/";
		}

		model.addAttribute("regActError", (String)map.get("actError"));
		return "other/regActError";
		
	}
	
	
	@RequestMapping("/sendActEmailAgain")
	public String sendActEmailAgain(@RequestParam("userId") String userId,Model model){
		
		User user = userService.selectUserById(userId);
		
		
		eventProducer.fireEvent(new EventModel(EventType.REG)
				.setActorId( userId )
				.setExt( "username", user.getGameName() )
				.setExt( "email", user.getEmail() )
				.setExt("activeCode", user.getActiveCode()) 
		);
		
		model.addAttribute("sendActAgain", "激活邮件已经发送，请查收");
		
		return "other/notice";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
     private static String getIpAddress(HttpServletRequest request) {  
         String ip = request.getHeader("x-forwarded-for");  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("Proxy-Client-IP");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("WL-Proxy-Client-IP");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("HTTP_CLIENT_IP");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getRemoteAddr();  
         }  
         return ip;  
     }  
	
	
	
	
	
}
