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
	
	// viewPost
	public void viewPost(int idx) {
		System.out.println(posts.get(idx));
	}
	
	// viewPostAll
	public void viewPostAll() {
		if(posts.isEmpty()) {
			System.err.println("게시글이 비어있습니다.");
			return;
		}
		
		for(int i = 0; i < posts.size(); i ++) {
			Post post = posts.get(i);
			String data = String.format("%d)제목:%s/글쓴이:%s\n", i+1, post.getTitle(), post.getId());
			System.out.println(data);
		}
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
	public void removePost(Post post) {
		int idx = searchPostId(post);
		posts.remove(idx);
	}
}
