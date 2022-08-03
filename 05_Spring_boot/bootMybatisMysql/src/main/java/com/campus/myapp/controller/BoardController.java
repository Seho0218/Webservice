package com.campus.myapp.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.BoardService;
import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

@RestController
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService service;
	
	ModelAndView mav = null; //변수를 초기화 해놔야함
	
	//게시판
	@GetMapping("boardList") //a태그
	public ModelAndView boardList(PagingVO pVO) {
		mav = new ModelAndView();
		
		//총 레코드 수
		pVO.setTotalRecord(service.totalRecord());
		
		
		
		//DB 레코드 선택 - 페이지, 검색어
		mav.addObject("list",service.boardList());
		
		mav.setViewName("board/boardList");
		return mav;	
	}
	
	//글쓰기폼
	@GetMapping("boardForm")
	public ModelAndView boardForm() {
		mav = new ModelAndView();
		mav.setViewName("board/boardForm");
		return mav;
	}
	//글쓰기 DB
	@PostMapping("boardFormOk")
	public ResponseEntity<String> boardFormOk(BoardVO vo,HttpServletRequest request){
		vo.setUserid((String)request.getSession().getAttribute("logId"));//세션 로그인 아이디
		vo.setIp(request.getRemoteAddr());//접속자의 아이피
		
		String msg = "<script>";
		try {
			service.boardWriteOk(vo);
			msg += "location.href='/board/boardList';";
		}catch(Exception e) {
			msg += "alert('글 등록이 실패하였습니다.');";
			msg += "history.go(-1)";
		}
		msg+="</script>";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=UTF-8");
		ResponseEntity<String> entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		return entity;
	}
}
