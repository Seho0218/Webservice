<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
   
   <style>
	#topMenu, #logo, #mainMenu, .footer{
	display:none;
	}
	#zipList li{float:left; border-bottom:1px solid #ddd;}
	#zipList li:nth-child(2n){width:95%;}
	#zipList li:nth-child(2n+1){width:5%;}
</style>
<script>
	$(function(){
		$("#zipFrm").submit(function(){
			if($("#doro").val==""){
				alert("도로명을 입력하세요..");
				return false;
			}
			return true;
		});
		//선택한 주소를 회원가입 폼으로 셋팅하고 현재창은 닫는다.
		$(".zip").click(function(){
			opener.$("#zipcode").val($(this).prev().text());//우편번호
			opener.$("#addr").val($(this).text()); //li의 문자열 받기
			window.close();
			
		})
	});	
</script>
    <div class ="">
    	<p>
    		도로명을 입력 후 우편번호 찾기를 하시기 바랍니다.
    	</p>
    	<form method = "get" action ="/member/zipSearch" id ="zipFrm" >
    		도로명 : <input type = "text" name = "doro" id = "doro"/>
    				<input type = "submit" value = "우편번호 찾기"/>
    	</form>
    	<hr/>
    	<ul id = "zipList">
    	<c:forEach var = "zipVo" items="${zipList}">
    		<li>${zipVo.zipcode}</li>											<!--  -->
    		<li class = 'zip'>${zipVo.sido}&nbsp;${zipVo.doro}&nbsp;${zipVo.buildname}&nbsp;${zipVo.buildingnum1}<c:if test="${zipVo.buildingnum2 !='0'}">-${zipVo.buildingnum2}</c:if>&nbsp;(${zipVo.dong} ,${zipVo.num1} <c:if test= "${zipVo.num2!='0'}">-${zipVo.num2}</c:if>)</li>
    	</c:forEach>
    	</ul>
    </div>