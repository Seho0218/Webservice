<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    //로그 아웃이 세션에 있는 모든 기록을 제거한다.
    // 세션 객체를 삭제하면 새로운 세션이 할당된다.

    session.invalidate();

    response.sendRedirect("/WebJsp/index.jsp");

%>