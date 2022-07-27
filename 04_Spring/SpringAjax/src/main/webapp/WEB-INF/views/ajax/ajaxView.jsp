<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script src ="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		//비동기식으로 서버에 접속하여 문자열을 결과로 리턴 받는다.
		$("#ajaxString").click(function(){
			var url = "/home/ajaxString";//매핑 주소
			var params = "num=123&name=세종대왕&tel=010-7878-8888";
			$.ajax({
				url:url,
				data : params,
				type : "GET",
				success:function(result){
					$("#view").append(result);
				},
				error:function(e){
					console.log(e.responseText);
				}
			});
		});
		///////////////////클릭  변수에 안 넣은 경우
		$("#ajaxObject").click(function(){
			$.ajax({
				url : "/home/ajaxObject",
					data : "num=567&username=이순신",
					type : "GET",
					success:function(obj){
						var tag = "<ol>";
						tag += "<li>번호 = "+obj.no+"</li>";
						tag += "<li>이름 = "+obj.username+"</li>";
						tag += "<li>연락처 = "+obj.tel+"</li>";
						tag += "<li>주소 = "+obj.addr+"</li></ol>";
						
						$("#view").append(tag);
					},
					error: function(){
						console.log("에러발생...");
					}
				});
			});
		//List 객체 얻어오기
		$("#ajaxList").click(function(){
			$.ajax({
				url: "/home/ajaxList",
				success:function(result){
					var tag = "<ul>";
					
					//컬렉션 list를 반복문을 돌리기 위해서는 컬렉션 변수를 선택자로 지정해야한다.
					var $result =$(result);
					
					$result.each(function(idx,vo){
						tag += "<li>" + vo.no + ","+vo.username+", "+vo.tel+"," +vo.addr+"</li>";
					});
						
					tag += "</ul>"
					$("#view").append(tag);
					
				},error:function(){
					console.log("List에러..");
				}			
			});	
		});
		//Map
		$("#ajaxMap").click(function(){	
			$.ajax({
				url:"/home/ajaxMap",
				success:function(result){
					var tag = "<ul>";
					tag += "<li>" + result.m1.no+","+result.m1.username+","+result.m1.tel+","+result.m1.addr+"</li>"
					tag += "<li>" + result.m2.no+","+result.m2.username+","+result.m2.tel+","+result.m2.addr+"</li>"
					tag += "<li>" + result.m3.no+","+result.m3.username+","+result.m3.tel+","+result.m3.addr+"</li>"//키와 벨류의 멤버변수
					tag += "</ul>";
					$("#view").append(tag);	
				},error:function(){
					console.log("에러발생..");
				}
			});
		});	
		// ajax를 이용하여 서버로 json 데이터 보내기
		// 		 클라이언트 json형식을 문자열로 보내기
		$("#ajaxJson").click(function(){
			var url = "/home/ajaxJson"
			var jsonData = {
					num :100,
					name :"홍길동",
					tel :"010-5656-8989"
			}
			$.ajax({
				url:url,
				type:"GET",
				data:jsonData,
				dataType:"json",
				success: function(result){
					//문자열을 json으로 변환하여야한다.
					var jsonString = JSON.stringify(result);
					console.log(jsonString);
					var json = JSON.parse(jsonString);
					console.log(json);
					
					var tag = "<ul>";
					tag += "<li>코드 :" +result.code +"</li>";
					tag += "<li>상품명 :" +result.productName +"</li>";
					tag += "<li>가격 :" +result.price +"</li>";
					$("#view").append(tag);
					
					
				},
				error : function(e){
					console.log(e.responseText);
				}
			});
		});
	});
</script>
</head>
<body>
<h1>비동기식으로 controller에 접속하여 정보를 리턴받는다.</h1>
<button id = "ajaxString">ajax 문자열</button>
<button id = "ajaxObject">ajax 객체</button>
<button id = "ajaxList">ajax List</button>
<button id = "ajaxMap">ajaxMap</button>
<button id = "ajaxJson">ajaxJson</button>
<hr/>

<div id="view" style="border : 1px solid gray;"></div>
</body>
</html>