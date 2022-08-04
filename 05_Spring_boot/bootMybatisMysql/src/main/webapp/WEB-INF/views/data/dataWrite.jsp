<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<script src="//cdn.ckeditor.com/4.19.1/full/ckeditor.js"></script>
<script>
		$(function(){
			CKEDITOR.replace("content");
			
		$("#dataFrm").submit(function(){
			if($("#title").val()==""){
				alert("제목을 입력하세요.");
				return false;
			}
			if(CKEDITOR.instances.content.getData()==""){
				alert("글 내용을 입력하세요.")
				return false;
			}
			var fileCount = 0;//선택한 첨부파일의 갯수
			if($("#filename1").val() != ""){
				fileCount++;
			}
			if($("#filename2").val() != ""){
				fileCount++;
			}
			
			if(fileCount<1){
				alert("첨부파일을 반드시 1개이상 선택하여야 합니다.");
				return false;
			}
			return true;	
		});	
	});
</script>
<div class = "container">
	<h1>자료실 글등록</h1>	
	<!--  form안에 파일 첨부가 있을 경우 form태그에는 반드시 enctype = "multipart/form-data"이 기술되어야 한다. -->
	<form method = "post" action = "/data/dataWriteOk" id ="dataFrm" enctype = "multipart/form-data">
		<ul>
			<li>제목</li>
			<li><input type = "text" name= "title" id = "title" style = "width:80%"/></li> <!-- name은 다른 것 하면 안됌. vo에 있는것으로-->
			<li>글내용</li>
			<li><textarea name = "content" id = "content"></textarea></li>
			<li>첨부파일</li>
			<li>
				<input type = "file" name = "filename" id = "filename1"/><!--  filename이 같아도 됌. -->
				<input type = "file" name = "filename" id = "filename2"/><!--  vo에 없는 이름으로 name을 정해야함. string과 파일 객체 충돌 -->
			</li>
			<li><input  type = "submit" value = "자료실 글 올리기"/></li>
		</ul>
	</form>
</div>