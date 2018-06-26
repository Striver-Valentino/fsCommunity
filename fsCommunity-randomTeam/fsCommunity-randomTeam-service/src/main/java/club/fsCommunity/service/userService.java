package club.fsCommunity.service;

import java.util.Map;

import club.fsCommunity.pojo.User;

public interface userService {

	Map<String,Object> registerUser(User user);
	
	Map<String,Object> loginrUser(User user);
	
	User selectUserByEmail(String email);
	
	
	
	
}
