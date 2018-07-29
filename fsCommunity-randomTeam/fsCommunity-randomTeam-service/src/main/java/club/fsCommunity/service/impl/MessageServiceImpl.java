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
	
	
	/**
	 * 增加一条站内信
	 */
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
		
		// 设置 会话id
		String conversationId = GeneralUtils.generateConversationId(fromId, toId);
		System.out.println("conversationId:" + conversationId);
		
		message.setConversationId(conversationId);
		
		
		// 插入数据库
		messageMapper.insert(message);
		
		map.put("addMessageSuc", "addMessageSuc");
		
		return map;
	}


	/**
	 * 得到 某用户 的 所有 站内信
	 */
	@Override
	public List<Message> getAllMessageByUserId(String userId) {
		
		MessageExample example = new MessageExample();
		
		// 根据逻辑表达式可以知道 a and ( b or c ) = ( a and b) or ( a and c )
		Criteria criteria1 = example.createCriteria();
		criteria1.andStatusEqualTo(0); // 只查找没有删除的站内信
		criteria1.andFromIdEqualTo(userId);
		
		Criteria criteria2 = example.createCriteria();
		criteria2.andStatusEqualTo(0);
		criteria2.andToIdEqualTo(userId);
		
		example.or(criteria2);   // userId 是  fromId 或者  toId
		
		// 设置排序，先按 enroll_date 逆向排序，如果 enroll_date 相同 ，再按 game_name 逆向排序
		example.setOrderByClause("`created_date` DESC,`content` DESC");
		
		List<Message> list = messageMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}


	/**
	 * 删除一条站内信（实际上只是 把 站内信的状态 修改为 1）
	 */
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
