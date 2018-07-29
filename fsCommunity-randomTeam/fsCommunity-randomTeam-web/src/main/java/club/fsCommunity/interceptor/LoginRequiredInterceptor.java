package club.fsCommunity.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import club.fsCommunity.model.HostHolder;

/**
 * 检查 用户 是否 有访问权限 的 拦截器
 */
@Service
public class LoginRequiredInterceptor implements HandlerInterceptor {

	@Autowired
	private HostHolder hostHolder;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		/**
         * 前一个拦截器 PassportInterceptor 已经 验证 过 登陆 的有效性，如果有效 才会把 user 对象 放到 hostHolder 并且 放行；
         * 如果 没有登陆，或 登陆 无效，是不会放行的，也不会 访问到 这个 LoginRequiredInterceptor 拦截器，所以 下面这个 判断 可有可无。
         */
		if(hostHolder.getUser() == null){ // hostHolder 里没有 用户，说明 没有登陆，不能访问，跳转到 登陆页面 去 先登陆
			response.sendRedirect("/login");
			return false;
		}
		
		/**
		 * 判断权限，比如 要登录管理员页面，那么要判断 用户 是否是 管理员。
		 */
		
		// 暂时 不写 判断权限 逻辑
		System.out.println("判断了用户权限");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
