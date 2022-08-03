<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	alert("${msg}이 실패하였습니다.");
	history.back();//history.go(-1); //redirect 다른 컨트롤러를 부르겠다.
</script>