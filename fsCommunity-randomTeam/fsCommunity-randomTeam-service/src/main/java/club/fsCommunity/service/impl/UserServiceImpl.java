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
			//System.out.println("userService user" + user.getEmail());
			//System.out.println("邮箱不能为空");
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
		
		
		/**
         * 如果以上的判断都通过，就可以真正开始注册了。
         */
		user.setId(randomNumberUtil.generateUserID());
		user.setStatus(1); // 以后 改为 1，激活后 才是 0。开发阶段 统一 先用 0。// 现在已经改为 1
		user.setSalt(randomNumberUtil.generateSalt());
		user.setPassword( randomNumberUtil.MD5( user.getPassword() + user.getSalt() ) );
		
		user.setCreateDate(new Date());
		
		user.setLastLoginDate(new Date()); // 记录最近登陆时间（因为默认注册成功，就登陆）
		
		// 如果用户没有设置头像，就用默认头像
		if(user.getHeadUrl() == null || "".equals(user.getHeadUrl())){
			user.setHeadUrl("http://pbjixg82v.bkt.clouddn.com/afe8f2d10300427eb18794886d1e690a.jpg");
		}
		
		// 给注册用户 一个 唯一 的 激活码，用于 激活邮件 的 发送
		user.setActiveCode(randomNumberUtil.generateEmailActiveCode());
		
		System.out.println("注册用户头像：" + user.getHeadUrl());
		
		userMapper.insert(user);
		
		
		/**
		 * 注册完，就默认登陆了。下发ticket票
		 */
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
		
		
		/**
         * 如果以上的判断都通过，就可以真正开始登陆了。
         */
		String loginIp = user.getLastLoginIp(); // 先备份一个 登陆的ip，否则 下一步的 user = user2 会把 旧的ip覆盖新的ip。
		user = user2;
		String ticket = addLoginTicket(user.getId());
		map.put("clubfsticket", ticket);
		
		map.put("user", user);
		
		
		System.out.println("loginIp:"+ loginIp);
		// 记录 最近 登陆 的 ip 以及 最近登陆时间
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
	
	/**
	 * 登出，把ticket票的状态改为1，作为过期
	 */
	@Override
	public int logout(String ticket) {
		
		LoginTicket loginTicket = new LoginTicket();
		loginTicket.setStatus(1);
		
		LoginTicketExample example = new LoginTicketExample();
		club.fsCommunity.pojo.LoginTicketExample.Criteria criteria = example.createCriteria();
		criteria.andTicketEqualTo(ticket);
		
		/**
		 * updateByExampleSelective：
		 * 第一个参数 是要修改的部分值组成的对象，其中有些属性为null则表示该项不修改。
	     * 第二个参数 是一个对应的查询条件的类， 通过这个类可以实现 order by 和一部分的where 条件。
		 */
		int i = loginTicketMapper.updateByExampleSelective(loginTicket, example);
		
		return i;
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
	 * 通过 游戏昵称  查找 用户
	 */
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

	
	
	/**
	 * 更新用户信息，修改昵称
	 * @param user
	 * @return
	 */
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
		
		/**
		 * 以上检查没问题后，正式开始  更新/修改
		 */
		
		/**
		 * updateByPrimaryKeySelective ：
		 * 第一个参数 是要修改的部分值组成的对象，其中有些属性为null则表示该项不修改。它会根据 部分值组成的对象 的 主键 字段 去修改。
		 */
		userMapper.updateByPrimaryKeySelective(user);
		
		map.put("updateUserGameNameSuc", "updateUserGameNameSuc");
		
		return map;
	}

	/**
	 * 更新用户信息，修改头像
	 */
	@Override
	public Map<String, Object> updateUserHeadUrl(User user) {
		
		Map<String,Object> map = new HashMap<>();
		
		if(user.getHeadUrl() == null || "".equals(user.getHeadUrl())){
			map.put("msgHeadUrl", "请先上传新的头像");
			return map;
		}
		
		/**
		 * 以上检查没问题后，正式开始  更新/修改
		 */
		
		
		/**
		 * updateByPrimaryKeySelective ：
		 * 第一个参数 是要修改的部分值组成的对象，其中有些属性为null则表示该项不修改。它会根据 部分值组成的对象 的 主键 字段 去修改。
		 */
		userMapper.updateByPrimaryKeySelective(user);
		
		map.put("updateUserHeadUrlSuc", "updateUserHeadUrlSuc");
		
		return map;
	}

	/**
	 * 修改用户密码
	 */
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
		
		// 以上检查通过后，可以正式开始 修改密码
		System.out.println("正式开始 修改密码");
		User user2 = new User();
		user2.setId(userId);
		user2.setSalt(randomNumberUtil.generateSalt());
		user2.setPassword( randomNumberUtil.MD5( newPwd + user2.getSalt() ) );
		
		userMapper.updateByPrimaryKeySelective(user2);
		
		map.put("updateUserPasswordSuc", "updateUserPasswordSuc");
		
		return map;
	}

	/**
	 * 根据 id 查找用户
	 */
	@Override
	public User selectUserById(String userId) {
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		return user;
	}

	
	/**
	 * 注册后，激活 邮件 的 激活链接 请求 过来 访问 的方法
	 * 
	 * 激活用户的逻辑
	 * 		1）检查随机激活码是否存在
	 * 		2）检查 激活链接 是否超过24小时
	 * 		3）检查邮箱是否正确     （安全问题，防止恶意激活）
	 *      4）检查用户是否已经激活过，防止重复激活。
	 * 		5）激活用户（修改user_list表的status值，改为1）
	 * 
	 * @return
	 */
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
		
		
		// 1）检查随机激活码是否存在
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andActiveCodeEqualTo(activeCode);
		List<User> list = userMapper.selectByExample(example);
		
		System.out.println("regActive_list:" + list);
		System.out.println("regActive_list.size():" + list.size());
		
		if(list != null && list.size() > 0){
			if(list.get(0) != null){
				// 2）检查 激活链接 是否超过24小时
				
				// 当前时间
				Date curDate = new Date();
				// 注册时间（也即发送激活邮件的时间，有一定的 偏差，但是没关系）
				Date regDate = list.get(0).getCreateDate();
				
				// 计算 最后过期时间（注册时间 24小时后），如果最后过期时间  早于  当前系统时间，则代表过期了
				Date lastTime = GeneralUtils.callLastTime(regDate, 1);
				
				if(curDate.before(lastTime)){ // 当前时间 比 最后过期时间 早，说明 没过期
					// 3）检查邮箱是否正确     （安全问题，防止恶意激活）
					if(list.get(0).getEmail().equals(email)){
						// 4）检查用户是否已经激活过，防止重复激活。
						if(list.get(0).getStatus() == 1){
							// 5）激活用户（修改status值，改为0）
							User user = new User();
							//user.setId(list.get(0).getId());
							user.setStatus(0);
							
							UserExample example2 = new UserExample();
							Criteria criteria2 = example2.createCriteria();
							criteria2.andIdEqualTo(list.get(0).getId());
							
							userMapper.updateByExampleSelective(user, example2);
							
							map.put("actSuc", "恭喜，激活成功，开始畅游fs社区吧");
							return map;
						}else{
							// 已经激活过
							map.put("actError", "你已经激活过，请不要重复激活");
							return map;
						}
						
					}else{
						// 邮箱不存在
						map.put("actError", "你的邮箱不正确");
						return map;
					}
					
				}else{
					// 激活链接 过期了
					map.put("actError", "你的激活链接过期了");
					return map;
				}
				
			}
			
			//随机激活码不存在
			map.put("actError", "你的激活链接不存在");
			return map;
			
		}else{
			//随机激活码不存在
			map.put("actError", "你的激活链接不存在");
			return map;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
