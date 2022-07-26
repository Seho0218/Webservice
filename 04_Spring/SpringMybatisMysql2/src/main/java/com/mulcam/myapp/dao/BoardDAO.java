package com.mulcam.myapp.dao;

import java.util.List;

import com.mulcam.myapp.vo.BoardVO;

public interface BoardDAO { //dao service 똑같이
	//글등록
	public int boardWriteOk(BoardVO vo);
	//글등록
	public List<BoardVO> boardList();
	//글선택
	public BoardVO boardView(int no);
	//조회수 증가
	public void hitCount(int no);
}
