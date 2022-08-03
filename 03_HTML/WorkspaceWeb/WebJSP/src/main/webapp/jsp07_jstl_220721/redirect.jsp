<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>

<c:redirect url="/jsp02_response_220720/login.jsp">
    <c:param name = "username">홍길동</c:param>
    <c:param name = "tel" value = "010-1234-5678"/>
</c:redirect>