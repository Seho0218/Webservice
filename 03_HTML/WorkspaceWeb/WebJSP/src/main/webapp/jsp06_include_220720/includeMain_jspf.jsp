<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #main{
        margin:0 auto;
        width:500px;
        height:500px;
        background-color: green;
    }

    #header{height:50px;background-color:lightblue;}
    #footer{height:50px; background-color:orange;}

</style>
</head>
<body>
<%@ include file = "header.jspf"%>
<div id = "main">
<%= username %><br/>
</div>

<%@ include file= "footer.jspf"%>
</body>
</html>