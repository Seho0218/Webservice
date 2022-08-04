package com.campus.myapp.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.MemberService;
import com.campus.myapp.vo.MemberVO;
import com.campus.myapp.vo.ZipcodeVO;

@RestController //�����Ҷ� modelandview�Ǵ� �������� ���� �� ����. 
@RequestMapping("/member/*")
public class MemberController {	
	@Inject
	MemberService service;
	
	//@RequestMapping("/member/memberForm")
	//@GetMapping get������θ� ���εǴ� ������̼� @PostMapping
	
	@GetMapping("memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/memberForm");
		return mav;
	}
	
	@GetMapping("idCheck") //���̵� �ߺ��˻�
	public ModelAndView idCheck(String userid) {
		ModelAndView mav = new ModelAndView();
		
		
		//DB��ȸ  : ���̵� �����ϴ��� Ȯ��
		 int cnt = service.idCheck(userid); //���� ���̵� �����ϴ� �� 0,1
		 
		 mav.addObject("idCnt",cnt);
		 mav.addObject("userid",userid);
		
		mav.setViewName("member/idCheck");
		return mav;
	}
	
	@GetMapping("zipSearch")
	public ModelAndView zipSearch(String doro) {
		ModelAndView mav = new ModelAndView();
		List<ZipcodeVO> list = service.zipSearch(doro);
		
		if(doro!=null && doro.equals("")) {
			list= service.zipSearch(doro);
		}
		//System.out.println(list.size());
		
		mav.addObject("zipList", list);
		
		
		mav.setViewName("member/zipSearch");
		return mav;
		
	}
	//ȸ�� �����ϱ�
	@PostMapping("memberWrite")// �� ������ requestmapping���� /�־ ��� ��.
	public ResponseEntity<String> memberWrite(MemberVO vo) {//�޼ҵ�� ������� ����
		
		//RestController������ ResponseBody�� ���� �� �ִ�.
		//Ŭ���̾�Ʈ���� �����Ϳ� �������� ���� �� �ִ� ��ü�̸�, ���������� ������ ���� �ʿ䰡 ����.
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=utf-8");
		
		try {//ȸ����� -> �α��������� �̵�
			int result = service.memberWrite(vo);
			
			String msg = "<script>";
			msg += "alert('ȸ�������� �����Ͽ����ϴ�. �α��� �������� �̵��մϴ�');";
			msg += "location.href='/member/login'";
			msg += "</script>";
			
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		}catch(Exception e) {//ȸ����� ���� -> ���������� history:���Ľ�ũ��Ʈ
			String msg = "<script>";
			msg += "alert('ȸ�������� �����Ͽ����ϴ�.');";
			msg += "history.back()";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg,headers,HttpStatus.BAD_REQUEST);
			
			e.printStackTrace();
		}
		return entity;
	}
	//�α��� ��
	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;
	}
	//DB ��ȸ
	@PostMapping("loginOK")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		MemberVO logVO = service.loginOk(vo);
	
		if(logVO != null) {//�α��� ����
			session.setAttribute("logId", logVO.getUserid());
			session.setAttribute("logName", logVO.getUsername());
			session.setAttribute("logStatus","Y");
			mav.setViewName("redirect:/");
			
		}else {//�α��� ����
			mav.setViewName("redirect:login");
		}
		return mav;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:/");
		
		return mav;
	}
	//ȸ������ ���� �� : ������ ���̵�� ���� ȸ�������� ������ �� ���������� �̵��ؾ��Ѵ�.
	@GetMapping("memberEdit")
	public ModelAndView memberEdit(HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		
		MemberVO vo = service.getMember(userid);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo",vo); // ȸ�������� ����ִ�vo
		mav.setViewName("member/memberEdit");
			
		return mav;
	}
	//ȸ������ ���� DB
	@PostMapping("memberEditOk")
	public ResponseEntity<String> memberEditOk(MemberVO vo) {// @RequestParam, @ReturnValue
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html",Charset.forName("UTF-8")));
		headers.add("Content-Type","text/html; charset=UTF-8");
		
		
		String msg = "<script>";
		int cnt = service.memberEditOk(vo);
			
		if(cnt>0) {//������
			msg+="alert('ȸ�������� �����Ǿ����ϴ�.');";
		}else {//��������
			msg+="alert('ȸ�������� ���������Ͽ����ϴ�.');";	
		}
		msg+="location.href='/member/memberEdit';</script>";
		
		entity = new ResponseEntity<String>(msg,headers, HttpStatus.OK);
		return entity;
	}
}