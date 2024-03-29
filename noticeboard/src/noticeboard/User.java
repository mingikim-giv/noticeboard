package noticeboard;

public class User {
	private String id, pw;
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
		
	@Override
	public String toString() {
		return String.format("%s/%s", this.id, this.pw);
	}
}