<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>폼을 이용한 서버로 데이터 보내기 </h1>
<form method ="post" action="formOk_220719.jsp">
    아이디 : <input type = "text" name="userid"/><br/><!-- 무조건 있어야함-->
    비밀번호 : <input type = "password" name = "userpwd"/><br/>
    이름 : <input type = "text" name = "username"/>

    <input type ="submit" value ="전송"/>
</form>
</body>
</html>