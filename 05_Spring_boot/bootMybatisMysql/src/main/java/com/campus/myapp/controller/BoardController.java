package com.campus.myapp.controller;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	ModelAndView mav = null; //������ �ʱ�ȭ �س�����
	
	//�Խ���
	@GetMapping("boardList") //a�±�
	public ModelAndView boardList(PagingVO pVO) {
		mav = new ModelAndView();
		
		//�� ���ڵ� ��
		pVO.setTotalRecord(service.totalRecord(pVO));
		
		
		//DB ���ڵ� ���� - ������, �˻���
		mav.addObject("list",service.boardList(pVO));
		mav.addObject("pVO",pVO);
		
		mav.setViewName("board/boardList");
		return mav;	
	}
	//�۾�����
	@GetMapping("boardForm")
	public ModelAndView boardForm() {
		mav = new ModelAndView();
		mav.setViewName("board/boardForm");
		return mav;
	}
	//�۾��� DB
	@PostMapping("boardFormOk")
	public ResponseEntity<String> boardFormOk(BoardVO vo,HttpServletRequest request){
		vo.setUserid((String)request.getSession().getAttribute("logId"));//���� �α��� ���̵�
		vo.setIp(request.getRemoteAddr());//�������� ������
		
		String msg = "<script>";
		try {
			service.boardWriteOk(vo);
			msg += "location.href='/board/boardList';";
		}catch(Exception e) {
			msg += "alert('�� ����� �����Ͽ����ϴ�.');";
			msg += "history.go(-1)";
		}
		msg+="</script>";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=UTF-8");
		ResponseEntity<String> entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		return entity;
	}
	//�۳��뺸��
	@GetMapping("boardView")
	public ModelAndView boardView(@RequestParam("no") int no, PagingVO pVO){
		
		//��ȸ�� ����
		service.hitCount(no);
		
		mav = new ModelAndView();
		mav.addObject("vo",service.getBoard(no));
		mav.addObject("pVO",pVO);
		mav.setViewName("/board/boardView");
		return mav;
	}
	//�ۼ��� ��
	@GetMapping("boardEdit/{num}")
	public ModelAndView boardEdit(@PathVariable("num") int no) {
		
		mav = new ModelAndView();
		
		mav.addObject("vo",service.getBoard(no));
		mav.setViewName("board/boardEdit");
		
		return mav;
}
	//�ۼ���: DB
	@PostMapping("boardEditOk")
	public ResponseEntity<String> boardEditOk(BoardVO vo, HttpSession session){
		//������ ���̵� ���Ѵ�.
		vo.setUserid((String)session.getAttribute("logId"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type", "text/html; charset-UTF-8");
		String msg = "<script>";
		try {
			service.boardEditOk(vo);
			//�����Ǿ��� - �۳��뺸��
			msg += "alert('���� �����Ǿ����ϴ�.');";
			msg += "location.href = '/board/boardView?no="+vo.getNo()+"';";
		}catch(Exception e) {
			e.printStackTrace();
			//���� �����϶�
			msg += "alert('���� �������� �ʾҽ��ϴ�.');";
			msg += "history.go(-1);";
		}
		msg += "</script>";
		return new ResponseEntity<String>(msg,headers,HttpStatus.OK);
	}
	//�� ����
	@GetMapping("boardDel")
	public ModelAndView boardDel(int no,HttpSession session) {
		int cnt = service.boardDel(no, (String) session.getAttribute("logId"));
		mav= new ModelAndView();
		if(cnt>0) {
			mav.setViewName("redirect:boardList");
		}else {
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
	//�������� ���ڵ� ����
	@PostMapping("multiDel")
	public ModelAndView multiDel(BoardVO vo) {
		
		int cnt = service.boardMultiDel(vo);
		System.out.println("������ ���ڵ� ��:"+cnt);
		
		mav=new ModelAndView();
		mav.setViewName("redirect:boardList");
		return mav;
	}
}