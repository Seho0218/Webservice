<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>백엔드에서 쿠키 저장</title>
<%
    //백엔드 (jsp)쿠키 저장
    // Cookie클래스를 객체로 만들어 response를 이용하여 클라이언트 컴퓨터에 정보를 보낸다.
                                //변수 , 값
    Cookie cookie = new Cookie("userid","goguma");
    Cookie cookie2 = new Cookie("nickname", "go");

    //소멸시점설정
    cookie.setMaxAge(40); // 쿠키의 생명주기를 초단위로 설정;, 단위는 분

    //클라이언트에게 전송 jsp에서 처리
    response.addCookie(cookie);
    response.addCookie(cookie2);
%>
</head>
<script> // 자바스크립트에서
    document.cookie = "notice = true";
    document.cookie = "text=ok";

</script>
<body>
<h1><a href="/WebJSP/jsp03_cookie/cookieView.jsp">쿠키 확인하기</a></h1>
</body>
</html>