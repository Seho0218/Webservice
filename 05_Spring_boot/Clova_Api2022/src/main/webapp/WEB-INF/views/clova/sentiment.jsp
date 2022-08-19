<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
     $(function(){
         $("#sentiBtn").click(function(){

             $.ajax({
                type:"post",
                dataType:"text",
                async:false,
				url:"/clova/sentimentOk",
				data:{
                    content:$("#content").val()
                },
                success:function(result){

                },error:function(e){
                    console.log(e.responseText);
                }
            });
        });
    });
</script>
<body>
<h2>Sentiment API</h2>
<p>텍스트 데이터를 분석해서 해당 단어/문장/문구 내용의 감정을 분석하는 서비스로 그 결과를 반환하는 HTTP 기반의 REST API입니다.</p>
글내용
<textarea id="content" id ="content" style="width:600px; height:400px;">
싸늘하다. 가슴에 비수가 날아와 꽂힌다.
한강이 넘치고 풍랑이 부니 기분이 좋다.
행복한 일이 많을 것 같다.
</textarea><br/>
<input type="button" id="sentiBtn" value="감정평가(neutral:중립, positive:긍정, negative:부정)"/>
<div id="sentiResult" style="background-color:#ddd"></div>
</body>
</html>