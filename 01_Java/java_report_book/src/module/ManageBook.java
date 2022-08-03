package module;

import java.io.*;
import java.util.*;
import java_report_book.BookDataSet;

public class ManageBook {
	Scanner scan = new Scanner(System.in);
	public String menu(){
		return "메뉴 [1.도서목록 2.도서등록 3.도서정보수정 4.도서정보삭제 5.장서현황 6.프로그램 종료] -> ";}
	public ManageBook(){
		BookDataSet.dataSet();
	do {
		try {
			System.out.print(menu());
			Integer MenuNum=Integer.parseInt(scan.nextLine());
			if(MenuNum.equals(1)) {bookList();}
			else if(MenuNum.equals(2)) {registBook();}
			else if(MenuNum.equals(3)) {EditBook();}
			else if(MenuNum.equals(4)) {DeleteBookinfo();}
			else if(MenuNum.equals(5)) {BookCnt();}
			else if(MenuNum.equals(6)) {quitProgram();}
			else {System.out.println("잘못 선택했습니다.");}
		}catch(Exception e) {
			System.out.println("없는 도서입니다.");
		}		
	}while(true);}
	
	public void bookList(){
		titlePrint();
		Collection<BookInfo> info = BookDataSet.bookList.values();
		Iterator<BookInfo> b = info.iterator();
		
		while(b.hasNext()) {
			BookInfo a = b.next();
			System.out.println(a.toString());
		}
	}
	public void titlePrint(){
		System.out.println("도서번호\t도서명\t저자\t출판사\t출판년도");}	
	public void registBook() {
		BookInfo info = new BookInfo();
		
		System.out.print("도서번호 ->");
		info.setBookNum(Integer.parseInt(scan.nextLine()));
		System.out.print("도서명 ->");
		info.setBookName(scan.nextLine());
		System.out.print("저자 ->");
		info.setAuthor(scan.nextLine());
		System.out.print("출판사 ->");
		info.setPublisher(scan.nextLine());
		System.out.print("출판년도 ->");
		info.setYear(Integer.parseInt(scan.nextLine()));
		BookDataSet.bookList.put(info.getBookNum(), info);
		System.out.println("책정보가 등록되었습니다.");}	
	public void EditBook(){
		
		System.out.print("수정할 도서 번호 : ");
		Integer booknum = Integer.parseInt(scan.nextLine());		
		BookInfo BI = BookDataSet.bookList.get(booknum);
		
		if(booknum.equals(BI.getBookNum())) {
			System.out.print("수정할 항목 [1.도서번호 2.도서명 3.저자 4.출판사 5.출판년도 그외) 돌아가기] : ");	
			String num= scan.nextLine();	
		
			if(num.equals("1")) {BooknumEdit(booknum);}
			else if(num.equals("2")){BooknameEdit(booknum);}
			else if(num.equals("3")){AuthorEdit(booknum);}
			else if(num.equals("4")){PublisherEdit(booknum);}
			else if(num.equals("5")){Publiyear(booknum);}			
		}}

	public void BooknumEdit(int booknum){//도서 정보 수정 -> 도서번호수
		BookInfo BI = BookDataSet.bookList.get(booknum);
		
		System.out.print("바꿀 도서번호 : ");
		Integer num = Integer.parseInt(scan.nextLine());
			
		if(num.equals(BI.getBookNum())){//k면 지우고 갱신함.
				System.out.println("이미 있는 번호입니다.");
		}else{
			BI.setBookNum(num);
			System.out.println("도서번호가 "+BI.getBookNum()+"로 바뀌었습니다.");}}	
	
	public void BooknameEdit(int booknum){
		BookInfo BI = BookDataSet.bookList.get(booknum);
		System.out.print("수정할 도서이름 : ");
		String bn = scan.nextLine();
		BI.setBookName(bn);
		System.out.println("도서이름이 "+BI.getBookName()+"로 바뀌었습니다.");
	}
	public void AuthorEdit(int booknum){
		BookInfo BI = BookDataSet.bookList.get(booknum);
		System.out.print("수정할 저자명 : ");
		String An = scan.nextLine();
		BI.setAuthor(An);
		System.out.println("저자명이 "+BI.getAuthor()+"로 바뀌었습니다.");
	}
	public void PublisherEdit(int booknum){
		BookInfo BI = BookDataSet.bookList.get(booknum);
		System.out.print("수정할 출판사 : ");
		String ep = scan.nextLine();
		BI.setPublisher(ep);
		System.out.println("출판사명이 "+BI.getPublisher()+"로 바뀌었습니다.");
	}
	public void Publiyear(int booknum){

		BookInfo BI = BookDataSet.bookList.get(booknum);
		System.out.print("수정할 출판년도 : ");
		int year = Integer.parseInt(scan.nextLine());
		BI.setYear(year);
		System.out.println("출판년도가 " + BI.getYear()+"로 바뀌었습니다");
	}
	public void DeleteBookinfo(){
		System.out.print("삭제할 도서 번호 : ");
		Integer num = Integer.parseInt(scan.nextLine());
		BookInfo BI = BookDataSet.bookList.get(num);
		
		if(num.equals(BI.getBookNum())){//k면 지우고 갱신함.
			
		BookDataSet.bookList.remove(num);
		System.out.println(num + "번 도서 정보를 삭제했습니다..");
		}}
	public void BookCnt(){
		System.out.printf("장서현황 : "+BookDataSet.bookList.size()+"권 \n");
	}
	public void quitProgram(){
			try {
			File f = new File("/Users/hongseho/Desktop/project2/java_report_book","book.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(BookDataSet.bookList);
			
			oos.close();
			fos.close();
		System.out.println("프로그램이 종료되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			System.exit(0);
	}
	public static void main(String[] args){
		new ManageBook();
	}}
