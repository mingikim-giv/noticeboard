package noticeboard;
// # 콘솔 게시판 만들기
// ㄴ Map 활용
// ㄴ User CRUD
// ㄴ Board CRUD

import java.util.Scanner;

public class NoticeRun {
	private Scanner scan = new Scanner(System.in);
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int WRITE = 5;
	private final int DELETE = 6;
	private final int VIEW = 7;
	private final int END = 8;
	
	// printMenu
	private void printMenu() {
		System.out.println("[===게시판===]");
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
		if(sel == JOIN) {
			
		}
		else if(sel == LEAVE) {
			
		}
		else if(sel == LOGIN) {
			
		}
		else if(sel == LOGOUT) {
			
		}
		else if(sel == WRITE) {
			
		}
		else if(sel == DELETE) {
			
		}
		else if(sel == VIEW) {
			
		}
		else if(sel == END) {
			
		}
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
	
	public void run() {
		printMenu();
		runMenu(inputNumber("메뉴 선택"));
	}
}
