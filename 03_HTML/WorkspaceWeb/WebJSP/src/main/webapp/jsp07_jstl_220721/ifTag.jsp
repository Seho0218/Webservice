<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1> if태그 :  조건문 </h1>
<c:set var = "n" value = "${10}"/>
<c:set var = "x" value = "${5}"/>
<c:if test="${n>x}">
    참일때 실행된다.
</c:if>

<c:if test ="${$n<x}">
    참일때 실행된다.
</c:if>

<c:if test ="${true}">
    무조건 참이다.
</c:if>

<h1>jstl에서 request하기, request.getParameter("name")  -> param.name</h1>
<c:set var = "name" value = "${param.name}"/>
이름 : ${name}<br/>
나이 : ${param.age}<br/>
연락처 : ${param.tel}<br/>