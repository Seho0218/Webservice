package com.mulcam.myapp.service;

import org.springframework.stereotype.Service;

import com.mulcam.myapp.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	//dao 객체 생성 MemberDAO dao = new MemberDAO();
	MemberDAO dao;

}
