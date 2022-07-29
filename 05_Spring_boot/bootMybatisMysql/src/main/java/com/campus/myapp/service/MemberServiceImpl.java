package com.campus.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Inject
	MemberDAO dao;

	@Override
	public int idCheck(String userid) {
		return dao.idCheck(userid);
	}

}
