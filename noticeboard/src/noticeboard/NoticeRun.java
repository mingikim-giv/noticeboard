package noticeboard;
// # 콘솔 게시판 만들기
// ㄴ Map 활용
// ㄴ User CRUD
// ㄴ Board CRUD

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoticeRun {
	private Scanner scan = new Scanner(System.in);
	
	private Map<String, User> userList;
	private UserManager userManager = UserManager.getInstance();
	private Board board;
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int WRITING_MENU = 5;
	private final int END = 6;
	
	private final int WRITE = 1;
	private final int DELETE = 2;
	private final int VIEW = 3;
	
	private String log;
	
	public NoticeRun() {
		userList = new HashMap<>();
		board = new Board();
		log = null;
	}
	
	// printMenu
	private void printMenu() {
		System.out.println("[===BBS===]");
		System.out.println("[1]회원 가입");
		System.out.println("[2]회원 탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]글 메뉴");
		System.out.println("[6]종료");
		System.out.println("[=========]");
	}
	
	// runMenu
	private void runMenu(int sel) {
		if(sel == JOIN && !isLogin()) {
			join();
		}
		else if(sel == LEAVE && isLogin()) {
			leave();
		}
		else if(sel == LOGIN && !isLogin()) {
			login();
		}
		else if(sel == LOGOUT) {
			logout();
		}
		else if(sel == WRITING_MENU	 && isLogin()) {
			writeSubMenu();
			wirteRunMenu(inputNumber("메뉴 선택"));
		}
		else if(sel == END) {
			
		}
	}
	
	// isLogin
	private boolean isLogin() {
		return log == null ? false : true;
	}
	
	// join
	private void join() {
		String id = inputString("ID");
		
		if(userManager.searchId(id)) {
			System.err.println("중복된 아이디입니다.");
			return;
		}
		else {
			String pw = inputString("PW");
			userManager.addUser(new User(id, pw));
			System.out.println("회원 가입 완료");
		}
	}
	
	// leave
	private void leave() {
		String pw = inputString("PW");
		User user = userManager.getUser(log);
		
		if(!user.getPw().equals(pw)) {
			System.err.println("비밀번호를 다시 입력하세요.");
			return;
		}
		
		userManager.removeUser(user);
		System.out.println("회원 탈퇴 완료");
		log = null;
	}
	
	// login
	private void login() {
		String id = inputString("ID");
		
		if(!userManager.searchId(id)) {
			System.err.println("회원 정보를 다시 입력해주세요.");
			return;
		}
		
		String pw = inputString("PW");
		User user = userManager.getUser(id);
		
		if(user.getPw().equals(pw)) {
			log = id;
			System.out.printf("%s님 로그인 성공\n", user.getId());
		}
	}
	
	// logout
	private void logout() {
		log = null;
		System.out.println("로그아웃 완료");
	}
	
	// writeSubMenu
	private void writeSubMenu() {
		viewPostAll();
		System.out.println("[1]글 작성");
		System.out.println("[2]글 삭제");
		System.out.println("[3]게시글 보기");
	}
	
	// wirteRunMenu
	private void wirteRunMenu(int sel) {
		if(sel == WRITE) {
			write();
		}
		else if(sel == DELETE) {
			delete(null);
		}
		else if(sel == VIEW) {
			view();
		}
	}
	
	// write
	private void write() {
		String title = inputString("제목");
		String content = inputString("내용");
		
		board.addPost(new Post("", title, content));
		System.out.println("글 작성 완료");
	}
	
	// delete
	private void delete(Post post) {
		board.removePost(post);
		System.out.println("글 삭제 완료");
	}
	
	// viewPostAll
	private void viewPostAll() {
		board.viewPostAll();
	}
	
	// view
	private void view() {
		if(board.isEmpty()) {
			System.err.println("게시글이 비어있습니다.");
			return;
		}
		
		int idx = inputNumber("number")-1;
		
		if(!board.indexOut(idx)) {
			System.err.println("번호를 다시 입력하세요.");
			return;
		}
		
		board.viewPost(idx);
	}
	
	// input
	private int inputNumber(String message) {
		int number = -1;
		
		try {
			System.out.println(message + ":");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	private String inputString(String message) {
		System.out.println(message + ":");
		return scan.next();
	}
	
	public void run() {
		while(true) {
			printMenu();
			runMenu(inputNumber("메뉴 선택"));
		}
	}
}
