package com.mulcam.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mulcam.myapp.dao.MemberDAO;
import com.mulcam.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	//dao 객체생성 MemberDAO dao = new MemberDAO();
	@Inject //객체생성해주는 어노테이션 = @Autowired
	MemberDAO dao;

	@Override
	public MemberVO login(MemberVO vo) {
		return dao.login(vo); //mapper로 아이디 비번 리턴
	}
}
