package noticeboard;
// # 콘솔 게시판 만들기
// ㄴ Map 활용
// ㄴ User CRUD
// ㄴ Board CRUD
public class NoticeRun {
	private final int JOIN = 1;
	
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
	
	public void run() {
		printMenu();
	}
}
