<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
	ul{overflow:auto;}
	#board li{
		float:left; line-height:40px; border-bottom:1px solid #ddd; width: 10%;
	}
	#board li:nth-child(5n+2){width:60%;
	white-space:nowrap; overflow:hidden; text-overflow:ellipsis;
	}
	
 	/* 페이지 */
 	#page li{
 		float:left; padding:10px;
 	}
</style>
<script>
	$("#searchFrm").submit(function(){
		if($("#searchWord").val()==""){
			alert("검색어를 입력하세요.");
			return false;
		}
		return true;
	});
});
</script>

<div class = "container">
	<h1>게시판 리스트</h1>
	<c:if test = "${logStatus=='Y'}">
	<div>
		<a href = "/board/boardForm">글쓰기</a>
	</div>
	</c:if>
	<div>
		${pVO.totalPage}/${pVO.nowPage}, 총레코드수:${pVO.totalRecord}
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
		<!-- 페이지 번호 -->
		<c:if test="${pVO.nowPage<=1}"><!-- 이전페이지가 없을때 -->
			<li>prev</li>
		</c:if>
		<c:if test = "${pVO.nowPage>1}">  <!-- 이전페이지 존재 -->
			<li><a href = "/board/boardList?nowPage=${pVO.nowPage-1}">prev</a></li>
		</c:if>
		<c:forEach var = "p" begin="${pVO.startPage}" end ="${pVO.startPage+pVO.onePageCount-1}">
			<!-- 출력할페이지 번호보다 작거나 같을때 -->
			<c:if test="${p<=pVO.totalPage}">
			<li
			<c:if test="${p==pVO.nowPage}">
				style = "background-color:#f00;color:#fff;"
			</c:if>
				><a href ="/board/boardList?nowPage=${p}">${p}</a></li>
			</c:if>
		</c:forEach>
		
		<!-- 다음페이지 -->
		<c:if test ="${pVO.nowPage==pVO.totalPage }">
			<li>next</li>
		</c:if>
		<c:if test ="${pVO.nowPage<pVO.totalPage }">
			<li><a href = "/board/boardList?nowPage=${pVO.nowPage+1}">next</a></li>
		</c:if>
		
		</ul>
	</div>
	<div>
		<form method = "get" action= "/board/boardList" id = "searchFrm">
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
    
    
