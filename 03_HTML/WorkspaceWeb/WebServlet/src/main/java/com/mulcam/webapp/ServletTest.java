package com.mulcam.webapp;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	response.setContentType("text/html; charset=UTF-8");
	
	PrintWriter pw = response.getWriter();
	
	pw.print("<html>");
	pw.print("<head>");
	pw.print("<title>로그인</title><body>");
	pw.print("<h1>로그인</h1><form method = 'post' action = ''/>");
	pw.print("아이디: <input type = 'text' name = 'userid'/><br/>");
	pw.print("비밀번호: <input type = 'password' name = 'userpwd'/><br/>");
	pw.print("<input type = 'submit' value = 'Login'/> </form></body></html>");
	pw.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메소드 실행됌.");
		
		
	}

}
