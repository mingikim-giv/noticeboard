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
	
	// searchId
	public int searchId(String id) {
		for(int i = 0; i < list.size(); i ++) {
			User user = list.get(i);
			if(user.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	// C.
	public void addUser(String id, String pw) {
		User user = new User(id, pw);
		list.add(user);
	}
	// R.
	public User getUser(int idx) {
		User user = list.get(idx);
		return user;
	}
	// U.
	public User setUser(int idx, User user) {
		return list.set(idx, user);
	}
	// D.
	public void removeUser(int idx) {
		if(idx < 0 || idx >= list.size()) {
			System.err.println("유효하지 않은 범위입니다.");
			return;
		}
		list.remove(idx);
	}
	
	// userSize	
	public int userSize() {
		return list.size();
	}
}
