package club.fsCommunity.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import club.fsCommunity.pojo.User;

public interface UserService {

	Map<String,Object> registerUser(User user);
	
	Map<String,Object> loginUser(User user);
	
	User selectUserByEmail(String email);
	
	User selectUserByGameName(String gameName);
	
	int logout(String ticket);
	
	// 更新用户信息，修改昵称
	Map<String,Object> updateUserGameName(User user);
	
	// 更新用户信息，修改头像
	Map<String,Object> updateUserHeadUrl(User user);
	
	// 修改用户密码
	Map<String,Object> updateUserPassword(String userId,String oldPwd,String newPwd,String confirmPwd);
	
	// 根据 id 查找用户
	User selectUserById(String userId);
	
	/**
	 * 注册后，激活 邮件 的 激活链接 请求 过来 访问 的方法
	 * 
	 * 激活用户的逻辑
	 * 		1）检查随机激活码是否存在
	 * 		2）检查是否超过24小时
	 * 		3）检查邮箱是否正确     （安全问题，防止恶意激活）
	 * 		4）激活用户（修改user_list表的status值，改为1）
	 * 
	 * @return
	 */
	Map<String,Object> regActive(String email,String activeCode);
	
	
}
