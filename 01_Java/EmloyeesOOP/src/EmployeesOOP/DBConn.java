package EmployeesOOP;

import java.sql.*;

public class DBConn {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = null;
	final String URL ="jdbc:mysql://@127.0.0.1/multi";
	final String DB_ID = "root";
	final String DB_PWD ="89138913";
	protected void getConn() {
		try {
			conn = DriverManager.getConnection(URL,DB_ID,DB_PWD);// 객체 대
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void getClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
