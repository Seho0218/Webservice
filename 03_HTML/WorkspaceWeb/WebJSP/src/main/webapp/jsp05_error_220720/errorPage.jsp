<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true"%> <!-- 에러페이지는 이게 있어야함-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생시 실행될 페이지</title>
</head>
<body>
<h1> 에러 발생시 실행될 페이지</h1>
<h2>
에러메시지 :
<%
    out.print(exception.getMessage());
%>
</h2>
<a href="webJSP/index.jsp"><img src=""/></a>
</body>
</html>