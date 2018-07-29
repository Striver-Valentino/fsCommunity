package club.fsCommunity.async.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.async.EventHandler;
import club.fsCommunity.async.EventModel;
import club.fsCommunity.async.EventType;
import club.fsCommunity.email.MailSender;

@Service
public class LoginExceptionHandler implements EventHandler {
	
	@Autowired
	private MailSender mailSender;
	

	@Override
	public void doHandle(EventModel eventModel) {
		System.out.println("LOGIN");
		
		
		
		if(1 == 1){
			return;
		}
		
		Map<String,Object> map = new HashMap<String ,Object>();
		map.put("username", eventModel.getExt("username"));
		
		/**
         * 发送 登陆 异常 的 邮件
         *
         * 其它 类似 的 发邮件 业务 也可以 异步化。
         */
		mailSender.sendWithHTMLTemplate(
				eventModel.getExt("email"), 
				"登陆异常", 
				"您好，您的登陆异常", 
				map
		);
		
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		List<EventType> list = new ArrayList<EventType>();
		list.add(EventType.LOGIN);
		
		return list;
	}

}
