<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
	#mFrm li{
		float:left; height: 40px; line-height:40px; border-bottom:1px solid #ddd; width: 30p%;
	}
	#mFrm li: nth-child(2n){width:70%}
	#mFrm li:last-of-type{width:100%; text-align:center}
</style>
<script>
	$(function(){
		$("#idChk").click(function(){
			window.open("/member/idCheck?userid="+$("#userid".val(),"idchk","width=400,height=300");
		});
	});
	

</script>
<body>
	<div class = "container">
		<h1>회원등록 페이지</h1>
		<form method = "post" action = "/member/memberWrite" id = "mFrm">
		<ul>
			<li>아이디</li>
			<li><input type ="text" name = "userid" id ="userid"/>아이디
				<input type = "button" value = "아이디중복검사" id = "idChk"/></li>
			<li><input type ="text" name = "userid" id ="userid"/>아이디</li>
			<li>비밀번호</li>
			<li><input type ="password" name = "userpwd" id ="userpwd"/>
			<li>비밀번호확인</li>
			<li><input type = "password" value = "userpwd2" id = "userpwd2"/></li>
			<li>이름</li>
			<li><input type ="text" name = "username" id ="username"/></li>
			<li>연락처</li>
			<li><input type ="text" name = "tel1" id ="tel1" size = "4"/> -
				<input type ="text" name = "tel2" id ="tel2" size = "4"/> -
			 	<input type ="text" name = "tel3" id ="tel3" size = "4"/></li>
			<li>이메일</li>
			<li><input type ="text" name = "email" id ="email"/></li>
			<li>우편번호</li>
			<li><input type ="text" name = "zipcode" id ="zipcode"/>
				<input type = "button" value = "우편번호찾기" id = "zipSearch"/><br/>
			<li>주소</li>
			<li><input type = "text" name = "addr" id = "addr"/></li>
			<li>상세주소</li>
			<li><input type ="text" name = "detailaddr" id ="detailaddr"/></li>	
			<li>
				<input type = "submit" value = "회원가입하기"/>
				<input type = "reset" value = "다시쓰기"/>
		</ul>
		</form>
	</div>
		
</body>
</html>