package com.campus.myapp.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.MemberService;

@RestController //리턴할때 modelandview또는 컨텐츠를 보낼 수 없다. 
@RequestMapping("/member/*")
public class MemberController {	
	@Inject
	MemberService service;
	
	//@RequestMapping("/member/memberForm")
	//@GetMapping get방식으로만 매핑되는 어노테이션 @PostMapping
	
	
	
	
	@GetMapping("memberForm")
	public ModelAndView memberForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberForm");
		return mav;
	}
	
	
	@GetMapping("idCheck") //아이디 중복검사
	public ModelAndView idCheck(String userid) {
		ModelAndView mav = new ModelAndView();
		
		
		//DB조회  : 아이디가 존재하는지 확인
		 int cnt = service.idCheck(userid); //같은 아이디가 존재하는 값 0,1
		 
		 mav.addObject("idCnt",cnt);
		 mav.addObject("userid",userid);
		
		mav.setViewName("member/idCheck");
		return mav;
	}
}
