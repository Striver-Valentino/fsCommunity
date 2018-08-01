package club.fsCommunity.interceptor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

/**
 * 网站入口拦截器，拦截所有请求，目的就是检查 有没有 登陆，以便于 决定  header.jsp 如何显示，以及 设置 HostHolder 里 的 当前 用户。
 * 
 * 注意，该拦截器 拦截所有 请求，但是 所有请求 都放行，它的目的 只是 检查 。如果 用户没有 登陆，HostHolder 里 的 当前 用户 就是 空值，
 * 网站里 有些 页面 是不需要 登陆的，有些 页面 需要 先登陆，是否 需要登陆，由 后面 的 拦截器 来判断。
 * 
 * @author Administrator
 *
 */
@Service
public class PassportInterceptor implements HandlerInterceptor {
	
	@Autowired
	private LoginTicketMapper loginTicketMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	HostHolder hostHolder;
	

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("PassportInterceptor 的 preHandle");
		
		String ticket = null;
		if(request.getCookies() != null){
			for (Cookie cookie : request.getCookies()) {
				if(cookie.getName().equals("clubfsticket")){
					ticket = cookie.getValue();
					break;
				}
			}
		}
		
		// 如果 ticket 不是 null，有值了，说明用户是登陆了的
        // 但是 也不能 完全 相信 ticket（ticket 有可能 是伪造的，它只是在cookie里叫"ticket"而已，内容是假的），还需要去 数据库 查一下 是否有，即使有，也还要 看看 是否过期。
		if(ticket != null){
			LoginTicketExample example = new LoginTicketExample();
			Criteria criteria = example.createCriteria();
			criteria.andTicketEqualTo(ticket);
			List<LoginTicket> list = loginTicketMapper.selectByExample(example);
			if(list != null && list.size() != 0){
				
				LoginTicket loginTicket = list.get(0);
				
				// 如果 loginTicket == null ，说明 ticket 是伪造的；
	            // 如果 ticket 过期时间 早于 当前时间，也是不行的；
	            // 如果 status 不等于0 ，说明 该 ticket 是无效的。
				if(loginTicket == null || loginTicket.getExpired().before(new Date()) || loginTicket.getStatus() != 0){
					// 如果 进入到这个 if ，说明 登陆 过期了，或没登陆，不在 hostHolder 里 设置 当前用户，且 放行。
					return true;
				}
			
			
				// loginTicket 正常有效 的时候，查出 对应的 用户。
				User user = userMapper.selectByPrimaryKey(loginTicket.getUserId());
				
				// 因为 这个查出的 User 在后面 还是要用到的，所以要把它保存起来，方便后面使用。
	            // 这里 把 user 保存在 本地线程 变量中（ThreadLocal 封装在 HostHolder 中）
				hostHolder.setUser(user);
				
				/**
				 * 为了方便 jsp 页面 也能 获取 当前 用户，把 当前 用户 也保存在 session 中
				 * 
				 * request.getSession(true)：若存在会话则返回该会话，否则新建一个会话。
				 *
				 * request.getSession(false)：若存在会话则返回该会话，否则返回NULL
				 */
				HttpSession session = request.getSession(true);
				session.setAttribute("loginUser", user);
				
				return true;
			}else{
				
				return true;
			}
		}
		
		// 如果 ticket 是 null，说明用户 没有 登陆，不在 hostHolder 里 设置 当前用户，且 放行。
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(modelAndView != null && hostHolder.getUser() != null){
			// 在视图 渲染 之前，把 用户对象 保存 到 modelAndView 中
            // modelAndView 是后台 与 前端 页面 交互 的 对象
            // 把 user 对象 传到 前端页面。所有 html 页面 都可以 获取这个 user
			modelAndView.addObject("userHost", hostHolder.getUser()); // 为了与 用 session 保存 当前用户 的 方法 区分，modelAndView 的 属性名叫 "userHost"
			/**
			 * modelAndView 是 把 数据 存放在 request域的，所以 ，可以在 header.jsp 中 用 ${!empty requestScope.userHost }  判断 用户 是否登陆。
			 * 
			 * postHandle() 是 在  后台逻辑处理完之后  且  视图 渲染 之前 执行的，在这个时候   把 用户对象 保存 到 modelAndView 中，
			 * 就可以在 所有 页面（不仅限于jsp页面）中  从 request域 取得 当前登录用户。
			 */
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		// 用户请求结束后，就 清理掉。如果不清理，保存的 用户 会越来越多，浪费资源。
		hostHolder.clear();
		
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute("loginUser");
			System.out.println("PassportInterceptor的afterCompletion() 清除后:" + session.getAttribute("loginUser"));
		}
		
	}
	
}
