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
	
	/**
	 * 上传图片
	 * @param file
	 * @return
	 */
	@RequestMapping("/uploadImage")
	@ResponseBody
	public Map<Object,Object> uploadImage(MultipartFile file){
		String imageUrl = null;
		Map<Object,Object> map = new HashMap<Object,Object>();
		try {
			imageUrl = cloudService.saveImage(file);
			
			if(imageUrl == null){
				map.put("code", 1); // 上传出错，code 是 1
				map.put("imageUrl", imageUrl);
			}
			
			map.put("code", 0); // 上传成功，code 是 0
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
		
		// user对象 保存 登陆 的ip，最后 通过 Mapper 保存到数据库，作为 最近 登陆 的 ip。（因为默认注册成功，就登陆）（如果 注册成功 才会 保存这个 最近 登陆 的 ip）
		String ipAddress = getIpAddress(request); // 根据 request 对象 获得 ip地址
		user.setLastLoginIp(ipAddress);
		System.out.println("ipAddress:"+ipAddress);
		
		//System.out.println("userService.registerUser 之前");
		Map<String, Object> map = userService.registerUser(user);
		//System.out.println("userService.registerUser 之后");
		
		if(map.containsKey("clubfsticket")){
			Cookie cookie = new Cookie("clubfsticket", map.get("clubfsticket").toString());
			
			cookie.setPath("/");
			cookie.setMaxAge(30*3600); // cookie 30小时有效；setMaxAge 单位是 秒，不是 毫秒。
			
			response.addCookie(cookie);
			
			
			Cookie cookieSession = new Cookie("JSESSIONID", session.getId());
			System.out.println("Reg_JSESSIONID:" + session.getId());
			
			cookieSession.setPath("/");
			cookieSession.setMaxAge(30*3600); // cookie 30小时有效
			
			response.addCookie(cookieSession);
			
			
			if(map.containsKey("user")){
				session.setAttribute("loginUser", (User)map.get("user"));
				hostHolder.setUser((User)map.get("user"));
			}
			
			model.addAttribute("regsuc", JsonUtil.getJSONString(0, "注册成功"));
			model.addAttribute("regSucPleaseAct", "您已注册成功，请到注册邮箱点击链接激活用户");
			
			
			/**
			 * 注册成功后，生成 注册 事件，因为需要发送 激活邮件
			 */
			eventProducer.fireEvent(new EventModel(EventType.REG)
					.setActorId( ((User)map.get("user")).getId() )
					.setExt( "username", ((User)map.get("user")).getGameName() ) // 设置 扩展信息；登陆用户的昵称；邮件 内容 需要用到
					.setExt( "email", ((User)map.get("user")).getEmail() )
					//.setExt( "email", "3540846483@qq.com" ) // 邮箱 应该用上一行的写法，但是由于 需要 注册 很多 测试邮箱（测试邮箱 一般都是 假的），所以 统一 写一个 真实可用 的邮箱。
					.setExt("activeCode", ((User)map.get("user")).getActiveCode()) // 邮箱激活码
			);
			
			
			// return "RegAndLoginSuccess";
			
			//登录成功，跳转到首页
			//return "redirect:/";
			//return "forward:/"; // model 保存的数据，只能用 转发
			
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
		
		//获取系统生成的验证码，从session域获取系统生成的验证码
		HttpSession session = request.getSession(false); // false，只获取，不创建；true，如果有session就获取，没有就创建。
		if(session != null){
			String sCode = (String)session.getAttribute("sCode");
			
			// 对比
			if(!vercode.trim().equals(sCode.trim())){
				model.addAttribute("msgvercode", "验证码错误");
				return "login";
			}
		}
		
		// 如果 验证码 通过
		
		// user对象 保存 登陆 的ip
		String ipAddress = getIpAddress(request); // 根据 request 对象 获得 ip地址
		user.setLastLoginIp(ipAddress);
		System.out.println("ipAddress:"+ipAddress);
		
		Map<String, Object> map = userService.loginUser(user);
		
		if(map.containsKey("clubfsticket")){
			Cookie cookie = new Cookie("clubfsticket", map.get("clubfsticket").toString());
			
			cookie.setPath("/");
			cookie.setMaxAge(30*3600); // cookie 30小时有效
			
			response.addCookie(cookie);
			
			
			Cookie cookieSession = new Cookie("JSESSIONID", session.getId());
			System.out.println("JSESSIONID:" + session.getId());
			
			cookieSession.setPath("/");
			cookieSession.setMaxAge(30*3600); // cookie 30小时有效
			
			response.addCookie(cookieSession);
			
			
			if(map.containsKey("user")){
				session.setAttribute("loginUser", (User)map.get("user"));
				hostHolder.setUser((User)map.get("user"));
			}
			
			model.addAttribute("loginsuc", JsonUtil.getJSONString(0, "登录成功"));
			//session.setAttribute("loginsuc", JsonUtil.getJSONString(0, "登录成功"));
			
			
			/**
			 * 生成 登陆 事件
			 */
			eventProducer.fireEvent(new EventModel(EventType.LOGIN)
					.setActorId( ((User)map.get("user")).getId() )
					.setExt( "username", ((User)map.get("user")).getGameName() ) // 设置 扩展信息；登陆用户的昵称
					.setExt( "email", ((User)map.get("user")).getEmail() )
					//.setExt( "email", "3540846483@qq.com" )
			);
			
			
			// return "RegAndLoginSuccess";
			
			//登录成功，跳转到首页
			return "forward:/";
			//return "index";  // 与上面 等价 的写法
		}else{
			model.addAttribute("loginerror", JsonUtil.getJSONString(1, map));
			
			return "login";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(@CookieValue("clubfsticket") String ticket,
			             HttpServletRequest request){
		
		// 把ticket票改为过期
		userService.logout(ticket);
		
		// 清除session里的用户信息
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute("loginUser");
			System.out.println(session.getAttribute("loginUser"));
		}
		
		//登出后，跳转到首页
		return "redirect:/";
	}
	
	/**
	 * 注册后，激活 邮件 的 激活链接 请求 过来 访问 的方法
	 * 
	 * 激活用户的逻辑
	 * 		1）检查随机激活码是否存在
	 * 		2）检查是否超过24小时
	 * 		3）检查邮箱是否正确     （安全问题，防止恶意激活）
	 *      4）检查用户是否已经激活过，防止重复激活。
	 * 		5）激活用户（修改user_list表的status值，改为1）
	 * 
	 * 测试错误跳转链接：http://localhost:8080/regActive?email=thty@qq.com&activeCode=fhthrtuyjyjtyjt
	 * 
	 * @return
	 */
	@RequestMapping("/regActive")
	public String regActive(@RequestParam("email") String email,@RequestParam("activeCode") String activeCode,Model model){
		
		Map<String, Object> map = userService.regActive(email, activeCode);

		if(map.containsKey("actSuc")){
			
			// 激活成功，把激活时间 记上
			User user = userService.selectUserByEmail(email); // 不能通过 hostHolder 取到用户，因为有 时候 用户 用另一个 浏览器 打开 激活邮件，而 那个浏览器 没有 记录 ticket票；邮箱 在数据库 有 唯一约束。
			user.setActiveDate(new Date());
			
			model.addAttribute("regActSuc", "激活成功");
			return "forward:/"; // model 保存的数据，只能用 转发
		}

		model.addAttribute("regActError", (String)map.get("actError"));
		return "other/regActError";
		
	}
	
	/**
	 * 重新发送激活邮件
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/sendActEmailAgain")
	public String sendActEmailAgain(@RequestParam("userId") String userId,Model model){
		
		User user = userService.selectUserById(userId);
		
		/**
		 * 再一次生成  注册 事件，因为需要 再一次 发送 激活邮件
		 */
		eventProducer.fireEvent(new EventModel(EventType.REG)
				.setActorId( userId )
				.setExt( "username", user.getGameName() ) // 设置 扩展信息；登陆用户的昵称；邮件 内容 需要用到
				.setExt( "email", user.getEmail() )
				//.setExt( "email", "3540846483@qq.com" ) // 邮箱 应该用上一行的写法，但是由于 需要 注册 很多 测试邮箱（测试邮箱 一般都是 假的），所以 统一 写一个 真实可用 的邮箱。
				.setExt("activeCode", user.getActiveCode()) // 邮箱激活码
		);
		
		model.addAttribute("sendActAgain", "激活邮件已经发送，请查收");
		
		return "other/notice";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** 
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
	 *  
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
     *  
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
	 * 192.168.1.100 
	 *  
	 * 用户真实IP为： 192.168.1.110 
	 *  
     * @param request 
	 * @return 
	 */  
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
