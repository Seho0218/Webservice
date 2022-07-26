package com.mulcam.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.myapp.service.MemberService;
import com.mulcam.myapp.vo.MemberVO;

@Controller
public class MemberControlloer {
	@Inject
	MemberService service;
	
	@RequestMapping("/login")
	public String login() {
		return "member/login"; //WEB_INF/views/member/login.jsp
	}

	//로그인(DB) 컨트롤러안 매핑주소 
	@RequestMapping(value ="/loginOK", method = RequestMethod.POST)
	//public loginOK(String userid, String userpwd) {
	public ModelAndView loginOk(MemberVO vo,HttpSession session){ // 바로 구해서 쓸거냐 왜 모델엔 뷰인가
		//vo를 매개변수로 사용하면 보낸 데이터 변수와 같은 이름을 가진 변수에 자동으로 request해준다.

		MemberVO resultVO = service.login(vo);
		//아이디,비밀번호가 있으면 아이디와 이름을 vo에 담아 리턴하고
		//없으면 null 리턴된다.
		ModelAndView mav = new ModelAndView();
		
		if(resultVO==null) {//로그인 실패
			mav.setViewName("redirect:login"); //requestmapping의 login으로.. jsp파이로가 다르다
		}else {// 로그인 성공
			//session기록
			//HttpSession session = request.getSession(); 구해서 쓸거냐
			session.setAttribute("logId",resultVO.getUserid());
			session.setAttribute("logName",resultVO.getUsername());
			session.setAttribute("logStatus","Y");
			//페이지
			mav.setViewName("redirect:/"); // /때문에 뷰로 간다.
		}
		return mav;	
	}
	//로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		//세션제거
		session.invalidate();
		
		ModelAndView mav = new ModelAndView(); // 다른 컨트롤러 바로 호출
		mav.setViewName("redirect:/");
		return mav;
	}
}