package noticeboard;

import java.util.ArrayList;

public class Board {
	private ArrayList<Post> posts;
	
	public Board() {
		posts = new ArrayList<>();
	}
	
	// searchPostId
	public int searchPostId(Post post) {
		for(int i = 0; i < posts.size(); i ++) {
			Post info = posts.get(i);
			if(info.getId() == post.getId()) {
				return i;
			}
		}
		return -1;
	}
	// C.
	public void addPost(Post post) {
		posts.add(post);
	}
	// R.
	public Post getPost(int idx) {
		Post post = posts.get(idx);
		return post;
	}
	// U.
	public Post setPost(int idx, Post post) {
		return posts.set(idx, post);
	}
	// D.
	public void removePost(int idx) {
		if(idx < 0 || idx >= posts.size()) {
			System.err.println("유효하지 않은 범위입니다.");
			return;
		}
		posts.remove(idx);
	}
}
