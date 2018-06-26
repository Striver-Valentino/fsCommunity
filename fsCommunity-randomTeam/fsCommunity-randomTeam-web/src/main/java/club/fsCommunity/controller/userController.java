package club.fsCommunity.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.fsCommunity.pojo.User;
import club.fsCommunity.service.userService;
import club.fsCommunity.utils.JsonUtil;
import club.fsCommunity.utils.ValidateCodeUtils;

@Controller
public class userController {

	@Autowired
	private userService userService;
	
	@RequestMapping("/initreg")
	public String initreg(){
		return "reg";
	}
	
	@RequestMapping("/imageCode")
	@ResponseBody
	public String imageCode(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(true);
		
		try {
			
			//生成一张随机验证码图片，并写出到浏览器
			ServletOutputStream out = response.getOutputStream();
			String sCode = ValidateCodeUtils.genNewCode(out);
			
			//把sCode共享给用户登录时使用（每个用户的验证码都不一样；以后，每个用户都有一份的，用session域共享）
			session.setAttribute("sCode", sCode);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	@RequestMapping("/reg")
	public String reg(@RequestParam("vercode") String vercode,
						User user,
						HttpServletRequest request,
						Model model,
						HttpServletResponse response){
		
		System.out.println("user:" + user);
		System.out.println("vercode:" + vercode);
		
		//获取系统生成的验证码，从session域获取系统生成的验证码
		HttpSession session = request.getSession(false); // false，只获取，不创建；true，如果有session就获取，没有就创建。
		if(session != null){
			String sCode = (String)session.getAttribute("sCode");
			
			// 对比
			if(!vercode.trim().equals(sCode.trim())){
				model.addAttribute("msgvercode", "验证码错误");
				return "reg";
			}
		}
		
		// 如果 验证码 通过
		
		System.out.println("userService.registerUser 之前");
		Map<String, Object> map = userService.registerUser(user);
		System.out.println("userService.registerUser 之后");
		
		if(map.containsKey("clubfsticket")){
			Cookie cookie = new Cookie("clubfsticket", map.get("clubfsticket").toString());
			
			cookie.setPath("/");
			cookie.setMaxAge(30*3600*1000); // cookie 30小时有效
			
			response.addCookie(cookie);
			
			model.addAttribute("regsuc", JsonUtil.getJSONString(0, "注册成功"));
			
			return "regsuccess";
		}else{
			model.addAttribute("regerror", JsonUtil.getJSONString(1, map));
			
			return "reg";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
