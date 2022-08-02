package com.campus.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.campus.myapp.vo.BoardVO;

@Mapper
@Repository
public interface BoardDAO {
	//글목록
	public List<BoardVO> boardList();
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
}
