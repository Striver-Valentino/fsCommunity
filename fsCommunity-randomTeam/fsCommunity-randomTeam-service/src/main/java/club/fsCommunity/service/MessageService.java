package club.fsCommunity.service;

import java.util.List;
import java.util.Map;

import club.fsCommunity.pojo.Message;
import club.fsCommunity.pojo.User;

public interface MessageService {
	
	// 增加一条站内信
	Map<String,Object> addMessage(String fromId,String toId,String content);
	
	// 得到 某用户 的 所有 站内信
	List<Message> getAllMessageByUserId(String userId);
	
	// 删除一条站内信（实际上只是 把 站内信的状态 修改为 1）
	Map<String,Object> deleteMessage(String messageId);
	
	
	
	
	
	
	
	
	
	

}
