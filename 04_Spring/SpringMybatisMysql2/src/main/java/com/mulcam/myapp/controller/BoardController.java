package com.mulcam.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.myapp.service.BoardService;
import com.mulcam.myapp.vo.BoardVO;

@Controller
public class BoardController {
	@Inject// 자동으로 변수를 넣어줌
	BoardService service;
	
	//글목록
	@RequestMapping("/board/list")		//이걸로 매핑 받는다.
	public ModelAndView boardList() {
		
		ModelAndView mav = new ModelAndView();
		
		//DB조회
		List<BoardVO> list = service.boardList();
		mav.addObject("list",list);
		mav.setViewName("board/boardList"); // 보드 리스트로 이동
		
		return mav;
		
	}
	//글쓰기 폼
	@RequestMapping("/board/write")
	public String boardWrite() {
		return "board/boardWrite"; //views에 있는 보드
	}
	//글쓰기 DB
	@RequestMapping(value="/board/writeOk",method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo,HttpServletRequest request) {
		//BoardVO내의 폼내의 subject, content는 request객체를 통해 getParameter()를 스프링이 실행해준다.
		
		vo.setIp(request.getRemoteAddr());//접속자의 아이피를 구하여 vo의 변수에 추가
		//vo.setUserid((String)request.getSession().getAttribute("logId"));
		
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("logId");
		vo.setUserid(userid);
		System.out.println(vo.getUserid());
		int cnt = service.boardWriteOk(vo);// 등록 확인 방법 0 보다 크면 등록
		
		ModelAndView mav = new ModelAndView();
		//등록이 된 경우 게시판 목록으로 이동
		if(cnt>0) {
			mav.setViewName("redirect:/board/list"); // 바로 호출가능 다른 컨트롤러를 호출해서 데이터 베이스를 조회한후 오겠다.매핑주소를 가리키기(이 파일 내에 잇음) 없으면그냥 페이지로 감
		}else {// 등록이 안된경우: 글쓰기 폼으로 이동
			mav.setViewName("board/boardResult");
		}
		
		return mav;
		//등록이 안된경우
	}
	//글내용보기
	@RequestMapping("/board/view")
	public String boardView(int no, Model model) {
		//조회수 증가
		
	service.hitCount(no);
		// 글선택
	BoardVO vo=	service.boardView(no);
	
	model.addAttribute("viewVO", vo); //vo를 viewVO로 넘김
	
	return "board/boardView";
	}
}
