package club.fsCommunity.model;
import org.springframework.stereotype.Service;
import club.fsCommunity.pojo.User;
@Service
public class HostHolder {
	private static ThreadLocal<User> Users = new ThreadLocal<User>();
	public User getUser(){
		return Users.get();
	}
	public void setUser(User user){
		Users.set(user);
	}
	public void clear(){
		Users.remove();
	}
}
