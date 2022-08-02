<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
	ul{overflow:auto;}
	#board li{
		float:left; line-height:40px; border-bottom:1px solid #ddd; width: 10%;
	}
	#board li:nth-child(5n+2){width:60%;
	white-space:nowrap; overflow:hidden; text-overflow:ellipsis;}
	
	
	
 	/* 페이지 */
 	#page li{
 		float:left; padding:10px;
 	}


</style>

<div class = "container">
	<h1>게시판 리스트</h1>
	<c:if test = "${logStatus=='Y'}">
	<div>
		<a href = "/board/boardForm">글쓰기</a>
	</div>
	</c:if>
	<div>
		총페이지수/현재페이지수
	</div>
	<ul id = "board">
		<li>번호</li>
		<li>제목</li>
		<li>작성자</li>
		<li>조회수</li>
		<li>등록일</li>	
		
		<c:forEach var = "vo" items="${list}">
			<li>${vo.no}</li>
			<li><a href="/board/boardView?no=${vo.no}">${vo.subject}</a></li>
			<li>${vo.userid}</li>
			<li>${vo.hit}</li>
			<li>${vo.writedate}</li>
		</c:forEach>
	</ul>
	<div>
		<ul id = "page">
			<li><a href = "/board/boardList">prev</a></li>
			
			<li><a href = "/board/boardList">1</a></li>
			<li><a href = "/board/boardList">2</a></li>
			<li><a href = "/board/boardList">3</a></li>
			<li><a href = "/board/boardList">4</a></li>
			<li><a href = "/board/boardList">5</a></li>
			
			<li><a href = "/board/boardList">next</a></li>
		</ul>
	</div>
	<div>
		<form method = "get" action= "/board/boardList">
			<select name = "searchKey">
				<option value = "subject">제목</option>
				<option value = "userid">작성자</option>
				<option value = "content">글내용</option>
			</select>
			<input type = "text" name="searchWord" id = "searchWord"/>
			<input type = "submit" name="Search"/>
		
		</form>
	</div>
</div>
    
    
