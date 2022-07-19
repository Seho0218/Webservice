<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<% 
    //post방식의 전송일때는 인코딩을 해준다.
    request.setCharacterEncoding("UTF-8");

    String userid = request.getParameter("userid");// 참조변수는 같아야함
    String userpwd = request.getParameter("userpwd");//데이터를 서버로 가져오는 request
    String username = request.getParameter("username");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=userid%><br/>  <!--=은 응답-->
비밀번호 : <%= userpwd %><br/>
이름 : <%=username%><br/>
</body>
</html>