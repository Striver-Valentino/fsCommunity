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
	
	
	
	/**
	 * 初始化 站内信 页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/initMessagePage")
	public String initMessagePage(Model model){
		String userId = hostHolder.getUser().getId();
		
		try {
			List<Message> list = messageService.getAllMessageByUserId(userId);
			
			List<Map<String,Object>> viewMapList = new ArrayList<Map<String,Object>>();
			
			for (Message message : list) { // Message 的 list 重新 封装 成   HashMap 的 list
				Map<String,Object> viewMap = new HashMap<String,Object>(); // 用于 页面展示 的 map
				
				viewMap.put("message", message);
				
				// message 里 只有 发信人id 与 收信人id，但是页面 需要 显示 发信人名字 与 收信人名字，所以 需要 先 查询出来
				User fromUser = userService.selectUserById(message.getFromId());
				User toUser = userService.selectUserById(message.getToId());
				
				if(fromUser == null || toUser == null){ // 如果 没有 发信人 或  没有 收信人，这条消息可能是非法的，不能显示，直接跳过
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
	
	/**
	 * 删除一条站内信
	 * @param messageId
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteMessage")
	public String deleteMessage(String messageId,Model model){
		
		System.out.println("deleteMessage");
		
		Map<String, Object> map = messageService.deleteMessage(messageId);
		
		if(map.containsKey("deleteMessageSuc")){
			model.addAttribute("delMessageOK", "delMessageOK");
			return "forward:/initMessagePage"; // 通过 url 跳转，不是通过 jsp 页面跳转
		}
		model.addAttribute("delMessageError", "删除出错");
		return "forward:/initMessagePage";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
