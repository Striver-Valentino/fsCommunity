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
import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.email.MailSender;


@Service
public class RegActiveEmailHandler implements EventHandler {
	
	@Autowired
	private MailSender mailSender;

	@Override
	public void doHandle(EventModel eventModel) {
		
		String domain_name = GeneralUtils.WEBSITE_DOMAIN_NAME;
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		String template = "亲爱的"+eventModel.getExt("username")+"用户：<br />&nbsp;&nbsp;恭喜您注册了fs社区，请于24小时内点击以下链接激活您的用户。<br />";
		template += "<a href='"+domain_name+"/regActive?email="+eventModel.getExt("email")+"&activeCode="+eventModel.getExt("activeCode")+"'>"
				+ "点击激活" + "</a>";
		
		mailSender.sendWithHTMLTemplate(
				eventModel.getExt("email"), 
				"激活邮件-fs社区注册激活邮件", 
				template, 
				map
		);
		
		
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		List<EventType> list = new ArrayList<EventType>();
		list.add(EventType.REG);
		
		return list;
	}

}
