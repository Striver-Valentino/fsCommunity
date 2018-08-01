package club.fsCommunity.interceptor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import club.fsCommunity.interceptor.LoginRequiredInterceptor;
import club.fsCommunity.interceptor.PassportInterceptor;

@Service
public class InterceptorWebConfiguration extends WebMvcConfigurerAdapter {
	
	
	
	
	@Autowired
	PassportInterceptor passportInterceptor;
	
	@Autowired
	LoginRequiredInterceptor loginRequiredInterceptor;
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//registry.addInterceptor(passportInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/reg","/");
		//registry.addInterceptor(passportInterceptor).addPathPatterns("/initLaunch");
		
		//registry.addInterceptor(loginRequiredInterceptor);
		
		super.addInterceptors(registry);
	}

}
