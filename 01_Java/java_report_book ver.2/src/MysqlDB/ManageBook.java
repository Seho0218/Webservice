package MysqlDB;

import java.util.*;


public class ManageBook extends DBConn{
	Scanner scan = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	BookVO vo = new BookVO();
	
	
	public ManageBook() {start();}
	
	public String menuShow() {
		System.out.print("메뉴[1.도서목록 2.도서등록 3.도서 정보 수정 4.도서 삭제 5.검색 6.장서 현황 7.종료] = ");
		return scan.nextLine();
	}
	
	public void start() {	
		try {
		do {
			String menu = menuShow();
			
			if(menu.equals("1")) {ListBook();
			}else if(menu.equals("2")) {AddBook();
			}else if(menu.equals("3")) {EditBook();
			}else if(menu.equals("4")) {DelBook();
			}else if(menu.equals("5")) {SearchBook();
			}else if(menu.equals("6")) {BookCnt();
			}else if(menu.equals("7")){CloseBook();}	
		}while(true);
		
	}catch(Exception e) {
		e.printStackTrace();}
	}
	//검색
	
	//회원목록
	public void ListBook() {
		//회원목록 DB에서 선택할 수 있는 메소드를 호출
		String searchWord = null;
		System.out.println("ISBN\t 책이름\t 저자\t 출판사\t 쪽수\t 출판일\t 상태 ");
		PrintBook(dao.SelectBook(searchWord));	
	}
	public void AddBook() {
		//회원번호, 이름, 부서명, 연락처, 이메일
		// 입력받은 데이터를 VO저장하기 위해서 객체를 생성
		System.out.printf("ISBN 번호를 입력하세요= ");
		vo.setBook_num(Integer.parseInt(scan.nextLine())); 
		
		System.out.printf("도서명을 입력하세요 ->");
		vo.setBookName(scan.nextLine());
		
		System.out.printf("저자 명을 입력하세요 =");
		vo.setAuthor(scan.nextLine());
		
		System.out.print("출판사 명을 입력하세요=");
		vo.setPublisher(scan.nextLine());
		
		System.out.printf("페이지수를 입력하시오=");
		vo.setPages(Integer.parseInt(scan.nextLine()));
		
		System.out.printf("발간일을 쓰시오=");
		vo.setWritedown(scan.nextLine());
		
		System.out.printf("대여 여부를 입력하세요[대여가능/예약가능/대여불가/반납완료] =");
		vo.setStatement(scan.nextLine());
		
		dao.InsertBook(vo);
	}	//회원수
	public void EditBook() {
		BookVO vo = new BookVO();//여기 좀 중요하게 다시 볼 것.
		
		System.out.print("수정할 도서번호 ->");
		vo.setBook_num(Integer.parseInt(scan.nextLine()));
		
		System.out.print("수정할 항목 선택[1.도서명 2.저자명 3.출판사 4.대여상황] ->");
		String editField = scan.nextLine();
		
		if(editField.equals("1")) {
			vo.setFieldName("BookName");
			System.out.print("수정 후 도서명 :");
			
		}else if(editField.equals("2")) {
			vo.setFieldName("Author");
			System.out.print("수정 후 저자명 :");
			
		}else if(editField.equals("3")) {
			vo.setFieldName("Publisher");
			System.out.print("수정 후 출판사명 :");
			
		}else if(editField.equals("4")) {
			vo.setStatement("Statement");
			System.out.print("수정 후 대여상황 : ");
		}
		
		vo.setBookName(scan.nextLine());
		
		BookDAO dao = BookDAO.getInstance();
		dao.UpdateBook(vo);
		int cnt = dao.UpdateBook(vo);
		if(cnt>0) {
			System.out.print("수정완료");
		}else {
			System.out.print("수정실패");
		}
	}
	//목록출력
	public void DelBook() {
		try {
			getConn();
			System.out.print("삭제할 도서 번호를 쓰시오 =");
			int Book_num = Integer.parseInt(scan.nextLine());
			sql="delete from book where ISBN = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Book_num);
			
			int result = pstmt.executeUpdate();
			System.out.println("삭제됐습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//회원추가
	public void SearchBook() {
		System.out.print("검색어 -> ");
		String searchWord = scan.nextLine();
		
		PrintBook(dao.SelectBook(searchWord));}
	public void PrintBook(List<BookVO> list) {
		
		for(int i = 0; i<list.size();i++) {
			vo = list.get(i);
			
			System.out.printf("%d\t %s\t %s\t %s\t %d\t %s\t %s \n",
					vo.getBook_num(),vo.getBookName(),vo.getAuthor(),
					vo.getPublisher(),vo.getPages(),vo.getWritedown(),vo.getStatement());
		}
	}
	
	public void BookCnt() {
		BookCnt(dao.SelectBook(null));
	}
	
	public void BookCnt(List<BookVO> list) {
		BookDAO dao = BookDAO.getInstance();
		System.out.println(list.size()+"권");
	}
	
	public void CloseBook() {System.exit(0);}	
	public static void main(String[] args) {
		new ManageBook();
	}}
