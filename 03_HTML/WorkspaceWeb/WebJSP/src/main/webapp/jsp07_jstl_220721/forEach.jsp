<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>


<h1>forEach 태그 : 반복문 </h1>
<h2>숫자를 이용한 반복문 </h2>
<c:set var = "dan" value = "7"/>
<c:forEach var = "n" begin="2" end="9" step="2"><!-- 생략하면 1씩 증가-->
    ${dan} *${n} = ${dan*n}<br/>
</c:forEach>

<h2>배열을 이용한 반복문 </h2>
<%
    int arr[] = {43,65,876,32,65,76,32,76,23};
%>
<c:forEach var = "data" items = "<%=arr%>">
    [${data }],
    </c:forEach>
<h2> 컬렉션 : ArrayList를 이용한 반복문</h2>

<%
    List<String> list = new ArrayList<String>();
    list.add("홍길동");
    list.add("세종대왕");
    list.add("이순신");
    list.add("장영실");
%>

<c:forEach var = "name" items="<%=list%>">
	[${name}]
</c:forEach>

</h2>Map을 이용한 반복문</h2>
<%
    HashMap<String, String> hm = new HashMap<String, String>();

    hm.put("name","홍길동");
    hm.put("addr","서울시 강남구 역삼동");
    hm.put("tel","010-1234-2222");
    hm.put("email","abcde@naver.com");
%>

<c:forEach var ="mapData" items="<%=hm%>">
    key : ${mapData.key} 값 : ${mapData.value}<br/>

</c:forEach>