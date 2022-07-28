<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
	#topMenu, #logo, #mainMenu, .footer{
	display:none;
	
	}
</style>

<div>
	사용가능한 아이디 입니다.
	<hr/>
	<form method = "post" action="">
		아이디 : <input type = "text" name = "userid" id = "userid"/>
		<input type = "submit" value ="아이디중복검사하기"/>
	
	</form>
	

</div>