package test.club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.fsCommunity.mapper.EnrollMapper;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.pojo.EnrollExample;
import club.fsCommunity.service.EnrollService;
import club.fsCommunity.service.MessageService;

public class MessageServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[]{"/spring/applicationContext-dao.xml", 
					"/spring/applicationContext-jedis.xml",
					"/spring/applicationContext-service.xml",
					"/spring/applicationContext-trans.xml",
					"/spring/springmvc.xml"
			});
	
	MessageService messageService = (MessageService) ac.getBean("messageService");
	
	@Test
	public void testAddMessage() {
		
		String fromId = "user669afadf1f6a400fb9a8b3ff7bb75ee2";
		String toId = "user240d35299ad34e06a170cc3bee2b0421";
		String content = "";
		
		for (int i = 0; i < 10; i++) {
			content = "欢迎欢迎2" + i;
			
			Map<String, Object> map = messageService.addMessage(fromId, toId, content);
			
			if(map.containsKey("addMessageSuc")){
				System.out.println("添加站内信成功");
			}else{
				System.out.println("添加站内信出错");
			}
			
		}
		
		System.out.println("所有测试站内信添加完成");
		
	}
	
}
