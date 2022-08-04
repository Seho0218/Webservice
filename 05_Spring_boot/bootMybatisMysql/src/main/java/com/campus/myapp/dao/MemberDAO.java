package com.campus.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.campus.myapp.vo.MemberVO;
import com.campus.myapp.vo.ZipcodeVO;

@Mapper
@Repository
public interface MemberDAO {
	//���̵� �ߺ��˻�
	public int idCheck(String userid);
	//�����ȣ ã��
	public List<ZipcodeVO> zipSearch(String doro);
	// ȸ������
	public int memberWrite(MemberVO vo);
	// �α���
	public MemberVO loginOk(MemberVO vo);
	//ȸ�� ����: �α��� �� ȸ��
	public MemberVO getMember(String userid);
	//ȸ�� ���� ����: DB ������Ʈ
	public int memberEditOk(MemberVO vo);

}