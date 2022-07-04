package mysql_jdbc;

import java.sql.*;
import java.util.Scanner;

public class SelectTest {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	Scanner scan = new Scanner(System.in);
	static {//생성자 메소드 보다 먼저 실행됨.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(Exception e) {e.printStackTrace();}
	}
	public SelectTest() {
		
	}
	public void start() {
		try {
			//2.db연결
			conn=DriverManager.getConnection("jdbc:mysql://@localhost/multi","root","89138913");
			String sql = "select mem_id, username, depart, tel, email, date_format(writedate, '%Y-%m-%d') writedate " + " from member order by username asc";
			
			pstmt = conn.prepareStatement(sql); //4시 46분부터 설명, statement 생성
			rs = pstmt.executeQuery();
		while(rs.next()) {
			int mem_id = rs.getInt(1);
			String username = rs.getString(2);
			String depart = rs.getString(3);
			String phone = rs.getString(4);
			String email = rs.getString(5);
			String writedate = rs.getString(6);
			System.out.printf("%8d %10s %10s %20s %30s %20s \n", mem_id, username, depart, phone, email, writedate);
			
		}
		}catch(Exception e) {e.printStackTrace();}
	finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}}

	//public static void main(String[] args) {
	//	new SelectTest().start();

	}


