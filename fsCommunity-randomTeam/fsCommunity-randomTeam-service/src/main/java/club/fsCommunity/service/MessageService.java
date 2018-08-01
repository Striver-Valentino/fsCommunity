package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import club.fsCommunity.pojo.Message;
import club.fsCommunity.pojo.User;

public interface MessageService {
	
	Map<String,Object> addMessage(String fromId,String toId,String content);
	
	List<Message> getAllMessageByUserId(String userId);
	
	Map<String,Object> deleteMessage(String messageId);
	
	
	
	
	
	
	
	
	
	

}
