package com.mulcam.myapp.dao;

import java.util.List;

import com.mulcam.myapp.vo.BoardVO;

public interface BoardDAO { //dao service �Ȱ���
	//�۵��
	public int boardWriteOk(BoardVO vo);
	//�۵��
	public List<BoardVO> boardList();
	//�ۼ���
	public BoardVO boardView(int no);
	//��ȸ�� ����
	public void hitCount(int no);
}
