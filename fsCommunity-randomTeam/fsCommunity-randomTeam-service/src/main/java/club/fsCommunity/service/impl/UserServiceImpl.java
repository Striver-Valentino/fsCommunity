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
import club.fsCommunity.mapper.LoginTicketMapper;
import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.pojo.LoginTicket;
import club.fsCommunity.pojo.LoginTicketExample;
import club.fsCommunity.pojo.User;
import club.fsCommunity.pojo.UserExample;
import club.fsCommunity.pojo.UserExample.Criteria;
import club.fsCommunity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private LoginTicketMapper loginTicketMapper;
	
	
	@Override
	public Map<String,Object> registerUser(User user) {
		
		System.out.println("userService user" + user);
		
		Map<String,Object> map = new HashMap<>();
		
		if( StringUtils.isBlank(user.getEmail()) ){
			map.put("msgemail", "邮箱不能为空");
			return map;
		}
		if(StringUtils.isBlank(user.getPassword())){
			map.put("msgpwd", "密码不能为空");
			return map;
		}
		
		User user2 = this.selectUserByEmail(user.getEmail());
		if(user2 != null){
			map.put("msgemail", "邮箱已经被注册");
			return map;
		}
		
		User user3 = this.selectUserByGameName(user.getGameName());
		if(user3 != null){
			map.put("msgGameName", "游戏昵称已经被注册");
			return map;
		}
		
		if(user.getPassword().length() < 10 || user.getPassword().length() > 16){
			map.put("msgpwd", "密码长度不符合要求");
			return map;
		}
		
		
		
		user.setId(randomNumberUtil.generateUserID());
		user.setStatus(1); 
		user.setSalt(randomNumberUtil.generateSalt());
		user.setPassword( randomNumberUtil.MD5( user.getPassword() + user.getSalt() ) );
		
		user.setCreateDate(new Date());
		
		user.setLastLoginDate(new Date()); 
		
		if(user.getHeadUrl() == null || "".equals(user.getHeadUrl())){
			user.setHeadUrl("http://pbjixg82v.bkt.clouddn.com/afe8f2d10300427eb18794886d1e690a.jpg");
		}
		
		user.setActiveCode(randomNumberUtil.generateEmailActiveCode());
		
		System.out.println("注册用户头像：" + user.getHeadUrl());
		
		userMapper.insert(user);
		
		
		
		String ticket = addLoginTicket(user.getId());
		map.put("clubfsticket", ticket);
		
		map.put("user", user);
		
		return map;
	}
	
	@Override
	public Map<String, Object> loginUser(User user) {

		Map<String,Object> map = new HashMap<>();
		
		if(StringUtils.isBlank(user.getEmail())){
			map.put("msgemail", "邮箱不能为空");
			return map;
		}
		if(StringUtils.isBlank(user.getPassword())){
			map.put("msgpwd", "密码不能为空");
			return map;
		}
		
		User user2 = this.selectUserByEmail(user.getEmail());
		if(user2 == null){
			map.put("msgemail", "邮箱没有注册");
			return map;
		}
		
		if( !randomNumberUtil.MD5(user.getPassword() + user2.getSalt()).equals(user2.getPassword()) ){
			map.put("msgpwd", "密码不正确");
			return map;
		}
		
		
		
		String loginIp = user.getLastLoginIp(); 
		user = user2;
		String ticket = addLoginTicket(user.getId());
		map.put("clubfsticket", ticket);
		
		map.put("user", user);
		
		
		System.out.println("loginIp:"+ loginIp);
		if(loginIp != null || !"".equals(loginIp)){
			User userRecordIpAndDate = new User();
			userRecordIpAndDate.setLastLoginIp(loginIp);
			userRecordIpAndDate.setLastLoginDate(new Date());
			
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(user.getId());
			
			userMapper.updateByExampleSelective(userRecordIpAndDate, example);
		}
		
		
		return map;
		
	}
	
	
	@Override
	public int logout(String ticket) {
		
		LoginTicket loginTicket = new LoginTicket();
		loginTicket.setStatus(1);
		
		LoginTicketExample example = new LoginTicketExample();
		club.fsCommunity.pojo.LoginTicketExample.Criteria criteria = example.createCriteria();
		criteria.andTicketEqualTo(ticket);
		
		
		int i = loginTicketMapper.updateByExampleSelective(loginTicket, example);
		
		return i;
	}
	
	
	
	

	
	@Override
	public User selectUserByEmail(String email) {
		
		User user = null;
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(example);
		
		for (User user2 : list) {
			if( email.equals(user2.getEmail()) ){
				user = user2;
			}
		}
		
		return user;
	}
	
	
	@Override
	public User selectUserByGameName(String gameName) {
		
		User user = null;
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andGameNameEqualTo(gameName);
		List<User> list = userMapper.selectByExample(example);
		
		for (User user2 : list) {
			if( gameName.equals(user2.getGameName()) ){
				user = user2;
			}
		}
		
		return user;
	}

	
	
	
	
	
	private String addLoginTicket(String userId){
		LoginTicket loginTicket = new LoginTicket();
		
		loginTicket.setId(randomNumberUtil.generateTicketID());
		loginTicket.setUserId(userId);
		loginTicket.setTicket(randomNumberUtil.generateTicketStr());
		loginTicket.setStatus(0);
		
		Date date = new Date();
		date.setTime(date.getTime() + 24*3600*1000);
		loginTicket.setExpired(date);
		
		loginTicketMapper.insert(loginTicket);
		
		return loginTicket.getTicket();
	}

	
	
	
	@Override
	public Map<String,Object> updateUserGameName(User user){
		
		Map<String,Object> map = new HashMap<>();
		
		System.out.println("updateUserGameName_user.getGameName():" + user.getGameName());
		
		if(user.getGameName() == null || "".equals(user.getGameName())){
			map.put("msgGameName", "游戏昵称不能为空");
			return map;
		}
		
		
		User user3 = this.selectUserByGameName(user.getGameName());
		
		System.out.println("user3:" + user3);
		if(user3 != null){
			map.put("msgGameName", "游戏昵称已经存在");
			return map;
		}
		
		
		
		
		userMapper.updateByPrimaryKeySelective(user);
		
		map.put("updateUserGameNameSuc", "updateUserGameNameSuc");
		
		return map;
	}

	
	@Override
	public Map<String, Object> updateUserHeadUrl(User user) {
		
		Map<String,Object> map = new HashMap<>();
		
		if(user.getHeadUrl() == null || "".equals(user.getHeadUrl())){
			map.put("msgHeadUrl", "请先上传新的头像");
			return map;
		}
		
		
		
		
		
		userMapper.updateByPrimaryKeySelective(user);
		
		map.put("updateUserHeadUrlSuc", "updateUserHeadUrlSuc");
		
		return map;
	}

	
	@Override
	public Map<String, Object> updateUserPassword(String userId,String oldPwd, String newPwd,String confirmPwd) {
		
		Map<String,Object> map = new HashMap<>();
		
		if(StringUtils.isBlank(oldPwd)){
			map.put("msgpwd", "当前密码不能为空");
			return map;
		}
		
		if(StringUtils.isBlank(newPwd)){
			map.put("msgpwd", "请填写新密码");
			return map;
		}
		
		if(StringUtils.isBlank(confirmPwd)){
			map.put("msgpwd", "请填写确认密码");
			return map;
		}
		
		if(!newPwd.trim().equals(confirmPwd.trim())){
			map.put("msgpwd", "新密码与确认密码不一样");
			return map;
		}
		
		User user = selectUserById(userId);
		if( !randomNumberUtil.MD5(oldPwd + user.getSalt()).equals(user.getPassword()) ){
			map.put("msgpwd", "当前密码不正确");
			return map;
		}
		
		System.out.println("正式开始 修改密码");
		User user2 = new User();
		user2.setId(userId);
		user2.setSalt(randomNumberUtil.generateSalt());
		user2.setPassword( randomNumberUtil.MD5( newPwd + user2.getSalt() ) );
		
		userMapper.updateByPrimaryKeySelective(user2);
		
		map.put("updateUserPasswordSuc", "updateUserPasswordSuc");
		
		return map;
	}

	
	@Override
	public User selectUserById(String userId) {
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		return user;
	}

	
	
	@Override
	public Map<String, Object> regActive(String email, String activeCode) {
		
		System.out.println("service_regActive_activeCode:" + activeCode);
		
		Map<String,Object> map = new HashMap<>();
		
		if(StringUtils.isBlank(email)){
			map.put("actError", "你的激活链接不对");
			return map;
		}
		
		if(StringUtils.isBlank(activeCode)){
			map.put("actError", "你的激活链接不对");
			return map;
		}
		
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andActiveCodeEqualTo(activeCode);
		List<User> list = userMapper.selectByExample(example);
		
		System.out.println("regActive_list:" + list);
		System.out.println("regActive_list.size():" + list.size());
		
		if(list != null && list.size() > 0){
			if(list.get(0) != null){
				
				Date curDate = new Date();
				Date regDate = list.get(0).getCreateDate();
				
				Date lastTime = GeneralUtils.callLastTime(regDate, 1);
				
				if(curDate.before(lastTime)){
					if(list.get(0).getEmail().equals(email)){
						if(list.get(0).getStatus() == 1){
							User user = new User();
							user.setStatus(0);
							
							UserExample example2 = new UserExample();
							Criteria criteria2 = example2.createCriteria();
							criteria2.andIdEqualTo(list.get(0).getId());
							
							userMapper.updateByExampleSelective(user, example2);
							
							map.put("actSuc", "恭喜，激活成功，开始畅游fs社区吧");
							return map;
						}else{
							map.put("actError", "你已经激活过，请不要重复激活");
							return map;
						}
						
					}else{
						map.put("actError", "你的邮箱不正确");
						return map;
					}
					
				}else{
					map.put("actError", "你的激活链接过期了");
					return map;
				}
				
			}
			
			map.put("actError", "你的激活链接不存在");
			return map;
			
		}else{
			map.put("actError", "你的激活链接不存在");
			return map;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
