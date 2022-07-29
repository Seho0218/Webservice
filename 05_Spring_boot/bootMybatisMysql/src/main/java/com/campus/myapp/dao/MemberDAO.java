package com.campus.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDAO {
	//아이디 중복검사
	public int idCheck(String userid);

}
