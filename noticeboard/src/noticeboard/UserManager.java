package noticeboard;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private Map<String, User> list;
	private static UserManager instance = new UserManager();
	
	public UserManager() {
		list = new HashMap<>();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	// searchId
	public boolean searchId(String id) {
		return list.containsKey(id);
	}
	
	// C.
	public void addUser(User user) {
		list.put(user.getId(), user);
	}
	// R.
	public User getUser(String id) {
		return list.get(id);
	}
	// U.
	public void setUser(User user) {
		list.replace(user.getId(), user);
	}
	// D.
	public void removeUser(User user) {
		list.remove(user.getId());
	}
	
	// userSize	
	public int userSize() {
		return list.size();
	}
}
