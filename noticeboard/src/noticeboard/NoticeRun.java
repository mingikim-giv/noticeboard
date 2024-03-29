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
	
	private UserManager userManager = UserManager.getInstance();
	private Map<String, User> userList;
	private Board board;
	
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int WRITE = 5;
	private final int DELETE = 6;
	private final int VIEW = 7;
	private final int END = 8;
	
	private int log;
	
	public NoticeRun() {
		board = new Board();
		userList = new HashMap<>();
		log = -1;
	}
	
	// printMenu
	private void printMenu() {
		System.out.println("[===BBS===]");
		System.out.println("[1]회원 가입");
		System.out.println("[2]회원 탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]글 쓰기");
		System.out.println("[6]글 삭제");
		System.out.println("[7]게시판 보기");
		System.out.println("[8]종료");
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
		else if(sel == WRITE && isLogin()) {
			
		}
		else if(sel == DELETE && isLogin()) {
			
		}
		else if(sel == VIEW && isLogin()) {
			
		}
		else if(sel == END) {
			
		}
	}
	
	// isLogin
	private boolean isLogin() {
		return log == -1 ? false : true;
	}
	
	// join
	private void join() {
		String id = inputString("ID");
		
		if(userList.containsKey(id)) {
			System.err.println("중복된 아이디입니다.");
			return;
		}
		else {
			String pw = inputString("PW");
			userList.put(id, new User(id, pw));
			System.out.println("회원 가입 완료");
		}
	}
	
	// leave
	private void leave() {
		String pw = inputString("PW");
		
		if(userManager.getUser(log).getPw().equals(pw)) {
			userManager.removeUser(log);
			log = -1;
			System.out.println("회원 탈퇴 완료");
		}
	}
	
	// login
	private void login() {
		String id = inputString("ID");
		
		if(!userList.containsKey(id)) {
			System.err.println("아이디가 존재하지 않습니다.");
			return;
		
		}
		
		User user = userList.get(id);
		String pw = inputString("PW");
		
		if(!user.getPw().equals(pw)) {
			System.err.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.printf("%s님 로그인 성공\n", user.getId());
	}
	
	// logout
	private void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
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
