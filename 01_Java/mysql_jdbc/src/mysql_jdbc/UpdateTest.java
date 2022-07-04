package mysql_jdbc;

public class UpdateTest extends DBConn {
	UpdateTest(){
		
	}
	public void updateStart() {
		try {
		//1. 드라이브 로딩]
		//2. DB연결
		getConn();
		//3.PreparedStatement
		sql = "update member set depart=?, tel=?, email=? where mem_id = ?";
		pstmt= conn.prepareStatement(sql);//객체생성
		pstmt.setString(1,"부서");
		pstmt.setString(2,"010-4444-5555");
		pstmt.setString(3,"abcd@abcd.com");
		pstmt.setInt(4,4000);
		
		int cnt = pstmt.executeUpdate();
		if(cnt>0) {
			System.out.println("수정됌.");
		}else{
			System.out.println("수정 못함");}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UpdateTest().updateStart();
	}

}
