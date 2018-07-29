package club.fsCommunity.interceptor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import club.fsCommunity.interceptor.LoginRequiredInterceptor;
import club.fsCommunity.interceptor.PassportInterceptor;

@Service
public class InterceptorWebConfiguration extends WebMvcConfigurerAdapter {
	/**
     * WebMvcConfigurerAdapter 是用来 自动配置 的 类。可以用来 注册 拦截器
     */
	
	
	
	@Autowired
	PassportInterceptor passportInterceptor;
	
	@Autowired
	LoginRequiredInterceptor loginRequiredInterceptor;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册自定义的拦截器
		// addPathPatterns 用于添加拦截规则
	    // excludePathPatterns 用户排除拦截
		
		
		// 先拦截，看看有没有登陆，看看登陆的用户是谁
		// addPathPatterns("/**")对所有请求都拦截，但是排除了/login和/reg 等 几个 请求的拦截
		//registry.addInterceptor(passportInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/reg","/");
		//registry.addInterceptor(passportInterceptor).addPathPatterns("/initLaunch");
		
		// 然后 再拦截，看看 有没有 访问权限
		//registry.addInterceptor(loginRequiredInterceptor);
		
		super.addInterceptors(registry);
	}

}
