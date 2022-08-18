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
		$(document).on('submit','#csrForm',function(){
			event.preventDefault();// 기본이벤트 제거 (form이라서)
			var filename=$("#audio").val();
			if(filename!=""){
				let point=filename.lastIndexOf(".");
				let extension = filename.substring(point+1);

				if(extension=='mp3' || extension=='aac' || extension=='ac3' || extension=='ogg'
						|| extension=='flac' || extension=='wav'){

					var formObj = new FormData($("#csrForm")[0]);
					var url="/clova/csr_speech_ok";

					$.ajax({
						type:"post",
						async:false,
						processData:false,
						contentType:false,
						data:formObj,
						dataType:"text",
						url:url,
						success:function(result, status){
							console.log(result);
							console.log(status);

							$("#csrResult").val(result);
						
							var jsonObject = JSON.parse(result);
							$("#csrTxt").html(jsonObject.text);
						
						},error:function(e){
							console.log(e.responseText);
						}
					});
				}else{
					alert("음성파일이 아닙니다..");
					return false;
				}
				}else{
					alert("음성파일을 선택하세요..");
					return false;
				}
			});
		});
</script>
</head>
<body>
	<h2></h2>
	<p></p>
	<form method = "post" enctype="multipart/form-data" id="csrForm" >
			음성 파일선택: <input type= "file" id = "audio" name = "audio"/><br/>
			<input type="submit" value="시작"/>
		</form>
		<textarea id="csrResult" style="width:600px; height:100px;"></textarea>
		<div id="csrTxt"></div>
</body>
</html>