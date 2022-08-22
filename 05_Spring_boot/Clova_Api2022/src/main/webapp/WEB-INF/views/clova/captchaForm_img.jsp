<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script>
$(function(){
    $("#captchaForm").submit(function(){
        if($("#userIn").val()==""){
            alert("이미지에 보이는 문자를 입력하세요.");
            return false;
        }
        return true;
    });
    $("#refresh").button(function(){

    })
})
</script>
</head>
<body>
<h2>Captcha(Image)</h2>
<p>
이미지 캡차 API는 자동 입력 방지를 위해 사람의 눈으로 식별 가능한 문자가 포함된 이미지를 전송하고 입력값을 검증하는 REST API입니다.

비로그인 오픈 API 이므로 GET으로 호출할 때 HTTP 헤더에 애플리케이션 등록 시 발급받은 Client ID와 Client Secret 값을 같이 전송해 활용할 수 있습니다.

캡차 기능 구현 절차는 다음과 같습니다.
<pre>
1.캡차키를 발급 요청하여 발급받습니다.
2.발급받은 캡차키를 이용해 캡차 이미지를 요청하여 발급받습니다.
3.사용자가 이미지를 보고 입력한 값을 캡차키와 비교합니다.
</pre>
</p>
<hr/>
<!-- 사용자에게 표시할 캡챠 이미지 -->
<img src="/clova/captchaImage"/><br/>
<form method="post" action="/clova/captchaCheck" id="captchaForm">
    <input type="button" name="refresh" id="refresh" value="새로고침"/>
    <input type="text" name="userIn" id="userIn"/>
    <input type="submit" value="전송하기"/>
</body>
</html>