package club.fsCommunity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.fsCommunity.mapper.LoginTicketMapper;
import club.fsCommunity.mapper.UserMapper;
import club.fsCommunity.pojo.LoginTicket;
import club.fsCommunity.pojo.User;
import club.fsCommunity.pojo.UserExample;
import club.fsCommunity.pojo.UserExample.Criteria;
import club.fsCommunity.service.userService;
import club.fsCommunity.utils.randomNumberUtil;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private LoginTicketMapper loginTicketMapper;
	
	
	@Override
	public Map<String,Object> registerUser(User user) {
		
		Map<String,Object> map = new HashMap<>();
		
		if( user.getName() == null || "".equals(user.getName().trim()) ){
			map.put("msgname", "邮箱不能为空");
			return map;
		}
		if(StringUtils.isBlank(user.getPassword())){
			map.put("msgpwd", "密码不能为空");
			return map;
		}
		
		User user2 = this.selectUserByEmail(user.getEmail());
		if(user2 != null){
			map.put("msgname", "邮箱已经被注册");
			return map;
		}
		
		if(user.getPassword().length() < 10 || user.getPassword().length() > 16){
			map.put("msgpwd", "密码长度不符合要求");
			return map;
		}
		
		
		/**
         * 如果以上的判断都通过，就可以真正开始注册了。
         */
		user.setId(randomNumberUtil.generateUserID());
		user.setStatus(0);
		user.setSalt(randomNumberUtil.generateSalt());
		user.setPassword( randomNumberUtil.MD5( user.getPassword() + user.getSalt() ) );
		
		userMapper.insert(user);
		
		
		/**
		 * 注册完，就默认登陆了。下发ticket票
		 */
		String ticket = addLoginTicket(user.getId());
		map.put("clubfsticket", ticket);
		
		return map;
	}
	
	@Override
	public Map<String, Object> loginrUser(User user) {

		Map<String,Object> map = new HashMap<>();
		
		System.out.println("user.getEmail():"+user.getEmail());
		if(StringUtils.isBlank(user.getEmail())){
			map.put("msgname", "邮箱不能为空");
			return map;
		}
		if(StringUtils.isBlank(user.getPassword())){
			map.put("msgpwd", "密码不能为空");
			return map;
		}
		
		User user2 = this.selectUserByEmail(user.getEmail());
		if(user2 == null){
			map.put("msgname", "邮箱没有注册");
			return map;
		}
		
		if( !randomNumberUtil.MD5(user.getPassword() + user2.getSalt()).equals(user2.getPassword()) ){
			map.put("msgpwd", "密码不正确");
			return map;
		}
		
		
		/**
         * 如果以上的判断都通过，就可以真正开始登陆了。
         */
		user = user2;
		String ticket = addLoginTicket(user.getId());
		map.put("clubfsticket", ticket);
		
		return map;
		
	}
	
	
	
	

	/**
	 * 通过用户名（邮箱） 查找 用户
	 */
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

	
	
	
	
	/**
	 * 生成一个 LoginTicket，并与 用户id 绑定
	 * @param userId
	 * @return
	 */
	private String addLoginTicket(String userId){
		LoginTicket loginTicket = new LoginTicket();
		
		loginTicket.setId(randomNumberUtil.generateTicketID());
		loginTicket.setUserId(userId);
		loginTicket.setTicket(randomNumberUtil.generateTicketStr());
		loginTicket.setStatus(0);
		
		Date date = new Date();
		date.setTime(date.getTime() + 24*3600*1000); // LoginTicket 有效期 24小时
		loginTicket.setExpired(date);
		
		loginTicketMapper.insert(loginTicket);
		
		return loginTicket.getTicket();
	}

	
	

}