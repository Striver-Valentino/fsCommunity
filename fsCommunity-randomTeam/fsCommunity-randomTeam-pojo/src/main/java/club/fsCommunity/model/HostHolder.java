package club.fsCommunity.model;

import org.springframework.stereotype.Service;

import club.fsCommunity.pojo.User;

/**
 * 表示当前用户是谁
 * @author Administrator
 *
 */
@Service
public class HostHolder { // HostHolder 用来 保存用户 与 取用户

	// 每个用户 有自己的 一个线程；因为 每个 HostHolder 里的 users 都是 new 出来的
	private static ThreadLocal<User> Users = new ThreadLocal<User>();
	
	// 取用户，只能取自己的 User
	public User getUser(){
		return Users.get();
	}
	
	// 保存用户；每个 本地线程 users 里，保存了 一个 User 对象
	public void setUser(User user){
		Users.set(user);
	}
	
	// 清除用户线程
	public void clear(){
		Users.remove();
	}
	
}
