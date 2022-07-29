<%@ page language="java" contentType="text/html; charset=EUC-KR"pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
   
   <style>
	#topMenu, #logo, #mainMenu, .footer{
	display:none;
	
	}
</style>
    <div class ="">
    	<p>
    		도로명을 입력 후 우편번호 찾기를 하시기 바랍니다.
    	</p>
    	<form method = "get" action ="">
    		도로명 : <input type = "text" name = "doro" id = "doro"/>
    				<input type = "submit" name = "doro" id = "우편번호 찾기"/>
    	</form>
    	<hr/>
    	<ul id = "zipList">
    		<li>1111</li>
    		<li>서울시 강남구 도곡로 9999</li>
    	</ul>
    </div>