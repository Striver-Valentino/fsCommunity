package club.fsCommunity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.fsCommunity.common.pojo.LayuiTableData;
import club.fsCommunity.common.utils.JsonUtil;
import club.fsCommunity.pojo.Enroll;
import club.fsCommunity.service.EnrollService;

@Controller
public class EnrollController {

	@Autowired
	private EnrollService enrollService;
	
	
	@RequestMapping("/submitEnroll")
	@ResponseBody
	public Map<String, Object> submitEnroll(Enroll enroll,Model model){
		
		System.out.println("报名页面传过来的:"+enroll);
		
		Map<String, Object> map = enrollService.addEnroll(enroll);
		
		Map<String, Object> map2 = new HashMap<>();
		
		if(map.containsKey("msgEnrollOK")){
			map2.put("data", "EnrollOK");
			return map2;
		}else{
			map2.put("data", JsonUtil.getJSONString(1, map));
			return map2;
		}
	}
	
	
	@RequestMapping("/showContestant/{gameId}")
	@ResponseBody
	public LayuiTableData showContestant(
			@PathVariable("gameId") String gameId,
			@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit){
		
		System.out.println("showContestant方法");
		System.out.println("showContestant_gameId：" + gameId);
		
		LayuiTableData layuiTableData = enrollService.selectUserByGameId(gameId, page, limit);
		
		return layuiTableData;
		
	}
	
	
	@RequestMapping("/toShowContestant")
	public String toShowContestant(@RequestParam("gameId") String gameId,Model model){
		
		System.out.println("toShowContestant_gameId:" + gameId);
		
		model.addAttribute("gameId", gameId);
		
		return "game/showContestant";
	}
	
	@RequestMapping("/testUrl")
	public String testUrl(@RequestParam("hello") String hello){
		
		System.out.println("hello:" + hello);
		System.out.println("测试URL");
		
		return "indexTest";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
