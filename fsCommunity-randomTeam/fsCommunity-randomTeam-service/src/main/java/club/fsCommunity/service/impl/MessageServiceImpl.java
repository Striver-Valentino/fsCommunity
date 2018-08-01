package club.fsCommunity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.common.utils.GeneralUtils;
import club.fsCommunity.common.utils.randomNumberUtil;
import club.fsCommunity.mapper.MessageMapper;
import club.fsCommunity.pojo.Message;
import club.fsCommunity.pojo.MessageExample;
import club.fsCommunity.pojo.MessageExample.Criteria;
import club.fsCommunity.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	
	
	@Override
	public Map<String, Object> addMessage(String fromId,String toId,String content) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(StringUtils.isBlank(fromId)){
			map.put("addMessageError", "没有发信人");
			return map;
		}
		if(StringUtils.isBlank(toId)){
			map.put("addMessageError", "没有收信人");
			return map;
		}
		if(StringUtils.isBlank(content)){
			map.put("addMessageError", "站内信没有内容");
			return map;
		}
		
		Message message = new Message();
		
		message.setFromId(fromId);
		message.setToId(toId);
		message.setContent(content);
		
		message.setId(randomNumberUtil.generateMessageID());
		message.setCreatedDate(new Date());
		message.setHasRead(0);
		message.setStatus(0);
		
		String conversationId = GeneralUtils.generateConversationId(fromId, toId);
		System.out.println("conversationId:" + conversationId);
		
		message.setConversationId(conversationId);
		
		
		messageMapper.insert(message);
		
		map.put("addMessageSuc", "addMessageSuc");
		
		return map;
	}


	
	@Override
	public List<Message> getAllMessageByUserId(String userId) {
		
		MessageExample example = new MessageExample();
		
		Criteria criteria1 = example.createCriteria();
		criteria1.andStatusEqualTo(0);
		criteria1.andFromIdEqualTo(userId);
		
		Criteria criteria2 = example.createCriteria();
		criteria2.andStatusEqualTo(0);
		criteria2.andToIdEqualTo(userId);
		
		example.or(criteria2);
		
		example.setOrderByClause("`created_date` DESC,`content` DESC");
		
		List<Message> list = messageMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}


	
	@Override
	public Map<String, Object> deleteMessage(String messageId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Message message = new Message();
		message.setId(messageId);
		message.setStatus(1);
		
		messageMapper.updateByPrimaryKeySelective(message);
		
		map.put("deleteMessageSuc", "deleteMessageSuc");
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
