<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<style>
	#view li{
	border-bottom :1px solid #ddd;
	margin:10px 0 10px;
	

</style>
<div class = "container">
	<h1>글내용 보기</h1>
	<ul>
		<li>번호 : ${viewVO.no}</li>
		<li>작성자 : ${viewVO.userid}</li>
		<li>등록일 : ${viewVO.writedate}</li>
		<li>조회수 : ${viewVO.hit}</li>
		<li>제목 : ${viewVO.subject}</li>
		<li>
			${viewVO.content}
		</li>
	</ul>
	
	<div>
	
		<a href="/myapp/board/edit?no=${viewVO.no}">수정</a>
		
		
		<a href="">삭제</a>
	
	</div>
</div>
