package com.mulcam.webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletTest() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet()메소드 실행됌.");
		
		//web.xml의 값을 Servlet클래스 가져오기
		
		String userid = getInitParameter("userid");
		System.out.println("userid ->"+ userid);
		
		
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
