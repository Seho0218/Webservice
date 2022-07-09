package EmployeesOOP;

import java.util.*;

public class EmpDAO extends DBConn {
	public EmpDAO() {}
	public static EmpDAO getInstance() {return new EmpDAO();}
	public List<EmpVO> empSelect(String searchWord){ //반환형 확인
	List<EmpVO> list =new ArrayList<EmpVO>();{
	
		try {
			getConn();
			
			sql = "select mem_id, username, depart,tel, email from member ";
			if(searchWord != null) {
				sql+=" where username like ? ";//검색어가 잇음
			}
			sql +=	"order by mem_id";
	
			pstmt = conn.prepareStatement(sql);
			
			if(searchWord != null) {
				pstmt.setString(1,"%"+ searchWord + "%");
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//회원을 vo에 담기
				
				EmpVO vo = new EmpVO();
				vo.setMem_id(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setDepart(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setEmail(rs.getString(5));
				//vo를 arraylist에 담기
				list.add(vo);		
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		getClose();
	}
	return list;
	}
}
	public int empInsert(EmpVO vo) {
		int result = 0;
		try {
			getConn();
			sql ="insert into member(mem_id,username, depart, " + "tel, email) values(?,?,?,?,?)";//여러칸띄워지는건 상관없다.
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getMem_id());
			pstmt.setString(2, vo.getUsername());
			pstmt.setString(3, vo.getDepart());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			getClose();
		}
		return result;
	}
	public int empUpdate(EmpVO vo) {
		int result = 0;  // result 반환값 2시 43분부터
		try {
			getConn();
			sql = "update member set " +vo.getFieldName() + "=? where mem_id=?";
			pstmt = conn.prepareStatement(sql); // 쿼리문으로 바꿔주는 메소드;
			pstmt.setString(1,vo.getPhone());
			pstmt.setInt(2, vo.getMem_id());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			getClose();
	}
		return result;
}
	public int empDelete(int mem_id) {
		int result = 0;
		try {
			getConn();
			sql="delete from member where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_id);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
}