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
		$("#fileupload").submit(function(){
			event.preventDefault();//기본이벤트 제거
			
			if($("#image").val()==""){
				alert("이미지를 선택하세요...");
				return false; //return;
			}
			
			var data = new FormData($("#fileupload")[0]);
			$.ajax({
				type:"post",
				url:"/clova/cfr_celebrity_ok",
				async:false,
				processData:false,
				contentType:false,
				data:data,
				dataType:"text",
				success:function(result){
					$("#txt").val(result);
				},error:function(e){
					console.log(e.responseText);
				}
			});		
		});
	});	
		
</script>
</head>
<body>
	<h2></h2>
	<pre></pre>
	<form method = "post" enctype="multipart/form-data" id="fileupload" >
			이미지 파일선택: <input type= "file" id = "image" name = "image"/><br/>
			<input type="submit" value="확인하기"/>
		</form>
		<textarea id="txt" style="width:600px; height:300px;"></textarea>
</body>
</html>