package club.fsCommunity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import club.fsCommunity.common.pojo.ViewObject;
import club.fsCommunity.model.HostHolder;
import club.fsCommunity.pojo.Message;
import club.fsCommunity.pojo.User;
import club.fsCommunity.service.MessageService;
import club.fsCommunity.service.UserService;

@Controller
public class MessageController {

	@Autowired
	private HostHolder hostHolder;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping("/initMessagePage")
	public String initMessagePage(Model model){
		String userId = hostHolder.getUser().getId();
		
		try {
			List<Message> list = messageService.getAllMessageByUserId(userId);
			
			List<Map<String,Object>> viewMapList = new ArrayList<Map<String,Object>>();
			
			for (Message message : list) {
				Map<String,Object> viewMap = new HashMap<String,Object>();
				
				viewMap.put("message", message);
				
				User fromUser = userService.selectUserById(message.getFromId());
				User toUser = userService.selectUserById(message.getToId());
				
				if(fromUser == null || toUser == null){
					continue;
				}
				
				viewMap.put("fromUserName", fromUser.getGameName());
				viewMap.put("toUserName", toUser.getGameName());
				
				viewMapList.add(viewMap);
			}
			
			model.addAttribute("viewMapList", viewMapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "user/message";
	}
	
	
	@RequestMapping("/deleteMessage")
	public String deleteMessage(String messageId,Model model){
		
		System.out.println("deleteMessage");
		
		Map<String, Object> map = messageService.deleteMessage(messageId);
		
		if(map.containsKey("deleteMessageSuc")){
			model.addAttribute("delMessageOK", "delMessageOK");
			return "forward:/initMessagePage";
		}
		model.addAttribute("delMessageError", "删除出错");
		return "forward:/initMessagePage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
