<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
	#replyList li{
		border-bottom:1px solid #ddd;
		margin:5px;
	}
</style>

<script>
	function boardDel(){
		if(confirm("글을 삭제하시겠습니까")){
			location.href="/board/boardDel?no=${vo.no}";		
		}
	}

	$(function(){
		//해당원글의 댓글 목록을 가져오는 함수
		function replyAllList(){
			//기존 목록 지우기
			$("#replyList>ul").empty();//$("#replyList>ul").html(""), $("#replyList>ul").text("");
			
			//비동기식으로 서버에 접속하여 댓글 목록을 가져온다.
			var url = "/reply/replyList";
			var params = {no:${vo.no}};
			console.log(params);
			
			$.ajax({
				url:url,
				data:params,
				success:function(result){
					var $reply = $(result);
					
					$reply.each(function(i, vo){
						tag= "<li>";
						tag+="<div><b>" + vo.userid+"("+vo.writedate+")</b>";
						//수정,삭제버튼(자신이 쓴 글일때만) 표시
						if(vo.userid=='${logId}'){
							tag+="<input type='button' value='Edit'/>";
							tag+="<input type='button' value='Del' title='"+vo.reply_no+"'/>";						
						}
						tag += "<br/>" +vo.coment+"</div>";
						//로그인 아이디와 댓글씅니가 같으면 폼을 만들어준다.
						if(vo.userid=='${logId}'){
							tag+="<div style='display:none'><form method='post'>";
							tag+="<input type='hidden' name='reply_no' value='"+vo.reply_no+"'/>";
							tag+="<textarea name ='coment' rows='4' cols='50'>"+vo.coment+"</textarea>";
							tag+="<input type='submit' value='댓글수정하기'/>";
							
							tag+="</div></form>";
						}
						tag+="<li>";
						
						$("#replyList>ul").append(tag);
							
					})
				},error:function(e){
					console.log(e.responseText);
				}
			})
		}

		//댓글쓰기
	$("#replyFrm").submit(function(){
		event.preventDefault(); // 기본이벤트 제거하기
		
		//var params = "no="+$("no").val()+"&coment="+$("#coment").val(); 폼의 값을 전송값으로 변환하는 함수
		var params = $("#replyFrm").serialize();
		$.ajax({
			url:"/reply/replyWrite",
			data:params,
			type:"POST",
			success:function(result){
				//댓글등록여부
				console.log("댓글등록수:",result);
				
				//이미 등록된 글 지우기
				$("#coment").val("");
				
				replyAllList(); // 목록다시설정
			},error:function(e){
				console.log(e.responseText);
			}
		});
	});
		
		//댓글수정하기(폼보기)
		//$("#replyList input[value=Edit]").click();
		$(document).on('click','#replyList input[value=Edit]',function(){
			$(this).parent().css("display","none");//Edit버튼의 부모를 숨김
			$(this).parent().next().css("display","block");//Edit폼 보여주기	
		});
		
		//댓글수정하기(DB)
		$(document).on('submit', '#replyList form', function () {
			event.preventDefault();
			var url = "/reply/replyEdit";
			var params = $(this).serialize();	
		//
		$.ajax({
			url:url,
			data:params,
			type:"POST",
			success:function(result){
				replyAllList();
			},error:function(e){
				console.log(e.responseText);			
			}
		
		});
	});	
		
		//댓글삭제
		$(document).on('click','#replyList input[value=Del]',function(){
			if(confirm("댓글을 삭제하시겠습니까?")){
			var params = {reply_no: $(this).attr('title')};
			$.ajax({
				url:"/reply/replyDel",
				data:params,
				success:function(result){
					replyAllList();
				},error:function(e){
					console.log(e.responseText);
				}
			});
		}
	});
		replyAllList();// 댓글 목록을 가져오는 함수 호출
});
</script>
	<div class = "container">
		<h1>글내용 보기</h1>
		<ul>
			<li>번호</li>
			<li>${vo.no}</li>
			<li>작성자</li>
			<li>${vo.userid}</li>
			<li>제목</li>
			<li>${vo.subject}
			<li>조회수 : ${vo.hit}, 등록일 : ${vo.writedate}</li>
			<li>글내용</li>
			<li>${vo.content}</li>
		</ul>
		<div>
		<a href="/board/boardList?nowPage=${pVO.nowPage}<c:if test ='${pVO.searchWord!=null}'> &searchKey=${pVO.searchKey} &searchWord=${pVO.searchWord} </c:if>">목록</a>
		<c:if test = "${vo.userid==logId}">
			<a href = "/board/boardEdit/${vo.no}">수정</a>
			<a href = "javascript:boardDel();">삭제</a>
		</c:if>
		</div>
		<hr/>
	<!-- 댓글달기 -->
	<div>
		<form method="post" id="replyFrm">
			<!-- 원글 번호는 숨겨서  -->
			<input type = "hidden" name="no" value="${vo.no}"/>
			<textarea maxlength="200" name="coment" id="coment" cols="50" rows ="3"></textarea>
			<input type="submit" value="댓글쓰기"/>					
		</form>	
	</div>
	<div id = "replyList">
	<ul></ul>
	</div>
</div>