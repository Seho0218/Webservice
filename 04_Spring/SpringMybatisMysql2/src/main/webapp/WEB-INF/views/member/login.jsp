<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <script>
    $("#log").submit(function(){
    	if($("#userid").val()==""){
    		alter("아이디를 입력하세요..");
    		return false;
    	}
    	$("#log").submit(function(){
        	if($("#userpwd").val()==""){
        		alter("비밀번호를 입력하세요..");
        		return false;
        	}
        	return true;
    	});	
	});
    
    </script>
    <style>
    #log ul{width:500px; margin: 0 auto;}
    #log li{margin-bottom:10px;}
    #loginput{width:500px;}
    
    </style>
   <div class ="container">
    <h1>로그인</h1>
    <form method = "post" action = "loginOK" id ="log">
    <ul>
    	<li>아이디</li>
    	<li><input type = "text" name = "userid" id = "userid"/></li>
    	<li>비밀번호</li>
    	<li><input type = "text" name = "userpwd" id = "userpwd"/></li>
    	<li><input type = "submit" value = "로그인"/></li>
     
    </ul>
    </form>	
   </div>
