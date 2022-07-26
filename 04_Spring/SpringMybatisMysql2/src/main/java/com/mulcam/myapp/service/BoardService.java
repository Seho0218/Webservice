package com.mulcam.myapp.service;

import java.util.List;

import com.mulcam.myapp.vo.BoardVO;

public interface BoardService {
	public int boardWriteOk(BoardVO vo);
	public List<BoardVO> boardList();
	public BoardVO boardView(int no);
	public void hitCount(int no);

}
