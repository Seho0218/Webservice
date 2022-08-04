package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

public interface BoardService {
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
	//�ѷ��ڵ�
	public int totalRecord(PagingVO pVO);
	//������ ����
	public int boardMultiDel(BoardVO vo);
}