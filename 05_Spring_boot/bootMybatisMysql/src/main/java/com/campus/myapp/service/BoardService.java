package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

public interface BoardService {
	//글목록
	public List<BoardVO> boardList(PagingVO pVO);
	//글등록
	public int boardWriteOk(BoardVO vo);
	//글선택(수정). 글내용보기
	public BoardVO getBoard(int no);
	//글수정
	public int boardEditOk(BoardVO vo);
	//글삭제
	public int boardDel(int no, String userid);
	//조회수 증가
	public void hitCount(int no);
	//총레코드
	public int totalRecord(PagingVO pVO);
	//여러개 삭제
	public int boardMultiDel(BoardVO vo);
}
