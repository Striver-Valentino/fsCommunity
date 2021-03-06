package club.fsCommunity.interceptor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import club.fsCommunity.mapper.LoginTicketMapper;
import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.model.HostHolder;
import club.fsCommunity.pojo.LoginTicket;
import club.fsCommunity.pojo.LoginTicketExample;
import club.fsCommunity.pojo.LoginTicketExample.Criteria;
import club.fsCommunity.pojo.User;


@Service
public class CheckLoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private LoginTicketMapper loginTicketMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	HostHolder hostHolder;
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("CheckLoginInterceptor 的 preHandle");
		
		String ticket = null;
		if(request.getCookies() != null){
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("clubfsticket")){
					ticket = cookie.getValue();
					break;
				}
			}
		}
		
		if(ticket != null){
			LoginTicketExample example = new LoginTicketExample();
			Criteria criteria = example.createCriteria();
			criteria.andTicketEqualTo(ticket);
			List<LoginTicket> list = loginTicketMapper.selectByExample(example);
			
			if(list != null && list.size() != 0){
				
				LoginTicket loginTicket = list.get(0);
			
				if(loginTicket == null || loginTicket.getExpired().before(new Date()) || loginTicket.getStatus() != 0){
					response.sendRedirect("/initlogin");
					return false;
				}
				
				User user = userMapper.selectByPrimaryKey(loginTicket.getUserId());
				
				hostHolder.setUser(user);
				return true;
			}else{
				response.sendRedirect("/initlogin");
				return false;
			}
			
		}
		
		response.sendRedirect("/initlogin");
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(modelAndView != null && hostHolder.getUser() != null){
			modelAndView.addObject("userHost", hostHolder.getUser()); 
			
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		hostHolder.clear();
		
	}
	
}
