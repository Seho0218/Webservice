<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        $("#voiceBtn").click(function(){
            let xhr=new XMLHttpRequest();

            xhr.responseType = "blob"; // 응답받는 데이터 타입

            //응답 받은 경우 실행하는 곳

            xhr.onload=function(){
                var audioURL=URL.createObjectURL(this.response);
                var audio = new Audio();
                audio.src=audioURL;
                audio.play();
            };
            
            //서버 매핑
            xhr.open("post","/clova/voiceOk");
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xhr.send("text="+$("#voiceText").val());
        });
    });
</script>
<style>
    #voiceText{
        width:100%;
        height:300px;
    }
</style>
</head>
<body>
    <h2>CLOVA Voice</h2>
    <p> Premium API는 음성으로 변환할 텍스트와 음색, 속도, 감정 등을 파라미터로 입력받은 후 음성을 합성하여 그 결과를 반환하는 HTTP 기반의 REST API입니다.</p>
    
    <textarea id="voiceText">
    			Premium API는 음성으로 변환할 텍스트와 음색, 속도, 감정 등을 파라미터로 입력받은 후
                음성을 합성하여 그 결과를 반환하는 HTTP 기반의 REST API입니다.	
    </textarea><br/>
    <input type="button" value="음성으로 변환하기" id="voiceBtn"/>
</body>
</html>