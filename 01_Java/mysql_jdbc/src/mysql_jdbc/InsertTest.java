package mysql_jdbc;

import java.sql.*;
import java.util.Scanner;

public class InsertTest {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Scanner scan = new Scanner(System.in);
	public InsertTest() {
		
	}
	public void start() {
		//1. Driver 로딩
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.db연결 ip
		String url ="jdbc:mysql://@127.0.0.1/multi";
		conn = DriverManager.getConnection(url,"root","89138913");
		
		//데이터준비
		System.out.print("회원번호->");
		int mem_id = Integer.parseInt(scan.nextLine());
		System.out.print("회원명 ->");
		String username = scan.nextLine();
		System.out.print("부서 ->");
		String depart = scan.nextLine();
		System.out.print("연락처 ->");
		String tel = scan.nextLine();
		System.out.print("이메일 ->");
		String email = scan.nextLine();
		
		//3.PreparedStatement객체를 생성(sql쿼리문);
		String sql = "insert into member(mem_id, username, depart, tel, email)" // 데이버 베이스 필드명과 같이 해야함.
				+ "values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mem_id);//숫자세팅
		pstmt.setString(2, username);
		pstmt.setString(3, depart);
		pstmt.setString(4, tel);
		pstmt.setString(5, email); //물음표가 있을때 하는것.
		
		//4.실행
		int cnt = pstmt.executeUpdate();
		if(cnt>0) {
			System.out.print("레코드가 추가되었습니다.");
		}else {
			System.out.print("추가실패");
		}
		
		}catch(ClassNotFoundException cnfe) {
			System.out.println("로딩 에러");
		}catch(SQLException se) {
			System.out.println("db 에러");
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InsertTest().start();
	}

}
