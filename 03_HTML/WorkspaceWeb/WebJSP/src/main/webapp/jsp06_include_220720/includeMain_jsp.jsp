<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
    width:1000px; height:1000px; margin:0 auto; background-color:cyan;
}
#top{height:50px; background-color:pink;}
#bottom{height:50px; background-color: #ddd;}

</style>
</head>
<body>
<!-- top.jsp include -->
<jsp:include page="top.jsp"/>
<div class = "container">
<%
    //jsp의 include는 변수를 호환하지 않는다
    //out.print(name);
%>
</div>
<jsp:include page="bottom.jsp"/>
</body>
</html>