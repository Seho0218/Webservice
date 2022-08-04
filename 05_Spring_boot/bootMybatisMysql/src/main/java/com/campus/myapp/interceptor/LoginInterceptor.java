package com.campus.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	//��Ʈ�ѷ��� ȣ��Ǳ����� ���ͼ����ϴ� �޼ҵ��̴�.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//�α��� ���� Ȯ���ϱ�
		HttpSession session = request.getSession();
		
		//session���� �α��� ������ ���ؿ´�.
		String logStatus = (String)session.getAttribute("logStatus"); // �α��� ���� Ȯ��
		
		if(logStatus != null && logStatus.equals("Y")) {
			//�α��λ����϶�
			return true;
		}else {
			//�α��� �ȵȰ��
		response.sendRedirect("/member/login");
		return false;	
		}	
	}
}