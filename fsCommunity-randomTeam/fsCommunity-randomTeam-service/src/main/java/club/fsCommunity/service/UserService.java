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
	
	Map<String,Object> updateUserGameName(User user);
	
	Map<String,Object> updateUserHeadUrl(User user);
	
	Map<String,Object> updateUserPassword(String userId,String oldPwd,String newPwd,String confirmPwd);
	
	User selectUserById(String userId);
	
	
	Map<String,Object> regActive(String email,String activeCode);
	
	
}
