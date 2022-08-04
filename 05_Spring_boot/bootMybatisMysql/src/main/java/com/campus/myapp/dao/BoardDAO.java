package com.campus.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

@Mapper
@Repository
public interface BoardDAO {
	//�۸��
	public List<BoardVO> boardList(PagingVO pVO);
	//�۵��
	public int boardWriteOk(BoardVO vo);
	//�ۼ���(����). �۳��뺸��
	public BoardVO getBoard(int no);
	//�ۼ���
	public int boardEditOk(BoardVO vo);
	//�ۻ���
	public int boardDel(int no, String userid);
	//��ȸ�� ����
	public void hitCount(int no);
	//�ѷ��ڵ��
	public int totalRecord(PagingVO pVO);
	//�������� ���ڵ� ����
	public int boardMultiDel(BoardVO vo); //vo�� ������ ���ڵ尡 �ִ�.
}