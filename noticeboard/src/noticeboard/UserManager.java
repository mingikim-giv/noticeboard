package noticeboard;

import java.util.ArrayList;

public class UserManager {
	private static ArrayList<User> list;
	private static UserManager instance = new UserManager();
	
	public UserManager() {
		list = new ArrayList<>();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	
}
