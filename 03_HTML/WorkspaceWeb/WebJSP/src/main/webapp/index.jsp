<!--  지시부 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Scanner"%>
<%! //선언부
    //메소드나 변수를 선언하는 영역
    public String gugudan(int dan){
        String tag = "<ul>";
        for(int i = 2; i<=9; i++){
            tag+= "<li>"+dan+"*"+i+"=" + (dan*i) +"</li>";
        }
        tag+="</ul>";
        return tag;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>header{height :100px; background:lime; color:#fff; line-height : 100px; text-align:center; font-size:4em;}</style>
</head>
<body>
<header> 멀캠 홈페이지</header>
<div>
<%
    //스크립트릿: 명령어 입력하는 곳
    int a = 100;
    String name = "홍길동";
    int c = a/3;

    Calendar now = Calendar.getInstance();

    System.out.println("c="+c);

    //내장 객체 : request , response , session , out, application , cookie

    out.print("c="+c); //웹 페이지는 줄이 안바뀜
%>
<hr/>
<%
    out.print("<h1>jsp에서 클라이언트에게 보낸 데이터</h1>");

    out.print(gugudan(7));
%>
a=<%=a+15%> //= out.print 역할 클라이언트에게 보내라는 뜻. 여러개는 못함
name=<%=name %><br/>
c=<%=c %>
request //아이디나 서버를 가져가는 내장객체
</div>
</body>
</html>