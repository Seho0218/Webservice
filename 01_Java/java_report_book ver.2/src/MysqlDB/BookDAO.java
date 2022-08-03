package MysqlDB;

import java.util.*;

public class BookDAO extends DBConn {
	public BookDAO() {}
	public static BookDAO getInstance() {return new BookDAO();}
	public List<BookVO> SelectBook(String searchWord){ //반환형 확인
	//BookDAO dao = new BookDAO();	
	List<BookVO> list =new ArrayList<BookVO>();
	
		try {
			getConn();
			
			sql = "select ISBN, BookName, Author, Publisher, pages, writedate, statement from book";
			if(searchWord != null) {
				sql+=" where ISBN like '%"+ searchWord + "%'";//검색어가 잇음
			}
	
			pstmt = conn.prepareStatement(sql);
			
			/*if(searchWord != null) {
				pstmt.setString(1,"%"+ searchWord + "%");
			}*/
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				//회원을 vo에 담기
				
				BookVO vo = new BookVO();
				vo.setBook_num(rs.getInt(1));
				vo.setBookName(rs.getString(2));
				vo.setAuthor(rs.getString(3));
				vo.setPublisher(rs.getString(4));
				vo.setPages(rs.getInt(5));
				vo.setWritedown(rs.getString(6));
				vo.setStatement(rs.getString(7));
				
				list.add(vo);				
		}	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		getClose();
	}
	return list;
	}
	public int InsertBook(BookVO vo) {
		int result = 0;
		try {
			getConn();
			sql ="insert book(ISBN, BookName, Author, Publisher, Pages, writedate, statement) values(?,?,?,?,?,?,?)";//여러칸띄워지는건 상관없다.
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,vo.getBook_num() );
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setString(4, vo.getPublisher());
			pstmt.setInt(5, vo.getPages());
			pstmt.setString(6, vo.getWritedown());
			pstmt.setString(7, vo.getStatement());
				
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			getClose();
		}
		return result;
	}
	public int UpdateBook(BookVO vo) {
		int result = 0;  // result 반환값 2시 43분부터
		try {
			getConn();
			sql = "update book set " +vo.getFieldName() + "=? where ISBN=?";
			pstmt = conn.prepareStatement(sql); // 쿼리문으로 바꿔주는 메소드;
			pstmt.setString(1,vo.getBookName());
			pstmt.setInt(2, vo.getBook_num());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			getClose();
	}
		return result;
}}
	