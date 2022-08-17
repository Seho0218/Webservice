<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#cfrForm").submit(function(){
			event.preventDefault();//기본이벤트 제거
			
			if($("#image").val()==""){
				alert("이미지를 선택하세요..");
				return false;
				}
				console.log(123);
				var form =$("#cfrForm")[0];
				var data = new FormData(form);
				
				$.ajax({
					type:"post",
					dataType:"text",
					url:"http://localhost:8050/cfrOk",
					async:false,
					processData:false,
					contentType:false,
					data:data,
					success:function(result){
						$("#txt").val(result);
						//문자열을 json으로 변환해준다. 여기서 부터 특징 보여줌
						//console.log(124);
						var jsonData = JSON.parse(result);
						$("#view").html(jsonData.faces[0].gender.value);
						$("#view").html(jsonData.faces[0].gender.value);
						$("#view").html(jsonData.faces[0].gender.value);
						$("#view").html(jsonData.faces[0].gender.value);
						$("#view").html(jsonData.faces[0].gender.value);
						
					},error:function(e){
						console.log(e.responseText);
					}
				});
		});
	});
</script>
</head>
<body>
	<div>
		<h1></h1>
		<p></p>
		
		<form method = "post" enctype="multipart/form-data" id="cfrForm" >
			이미지 파일선택: <input type= "file" id = "image" name = "image"/><br/>
			<button id ="cfr">확인하기</button>
			<input type="submit" value="Ok"/>
			<input type="image" src=""/>
		</form>
		<hr/>
		<textarea id = "txt" rows="20" cols="100"></textarea>
	</div>
	<div id="view"></div>
</body>
</html>