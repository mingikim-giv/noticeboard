package noticeboard;

public class Post {
	private String id;
	private String title;
	private String content;
	
	public Post(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public String getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		String data = String.format("[제목:%s]\n", title);
		data += String.format("[글쓴이:%s]\n", id);
		data += String.format("[내용:%s]\n", content);
		
		return data;
	}
}
