<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userid = request.getParameter("userid");//인코딩 안해도 됌. 한글로 가져올거라서 11시 38분
    String userpwd = request.getParameter("userpwd");


    //DB조회
    if(userid.equals("goguma") && userpwd.equals("1234")){// 로그인 성공
        //
        response.sendRedirect(request.getContextPath()+ "/index.jsp"); // 클라이언트는 못보는 페이지

    }else{//로그인 실패

    //response.sendRedirect("/WebJSP/jsp02_response/login.jsp");
%>

    <script>
        history.go();// 전전 화면:-2 request는 이전페이지의 정보를 가져온다.    클라이언트 컴퓨터에 필요한 정보 저장=쿠키
    </script>
<%
    }
%>