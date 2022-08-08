package com.campus.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.myapp.service.ReplyService;
import com.campus.myapp.vo.ReplyVO;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	ReplyService service;
	
	@PostMapping("replyWrite")
	public int replyWrite(ReplyVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));//작성자	
		return service.replyInsert(vo);	
	}
	//댓글 목록 선택
	@GetMapping("replyList")
	public List<ReplyVO> replyList(int no) {
		return service.replyList(no);
	}
	//댓글수정
	@PostMapping("replyEdit")
	public int replyEdit(ReplyVO vo, HttpSession ses) {
		vo.setUserid((String)ses.getAttribute("logId"));
		return service.replyUpdate(vo);
	}
	//댓글삭제
	@GetMapping("replyDel")
	public int replyDel(int reply_no, HttpSession s) {
		String userid = (String)s.getAttribute("logId");
		return service.replyDelete(reply_no,userid);	
	}
}
