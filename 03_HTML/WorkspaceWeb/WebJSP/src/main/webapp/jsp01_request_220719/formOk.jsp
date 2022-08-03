<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>

<% 
    //post방식의 전송일때는 인코딩을 해준다.
    request.setCharacterEncoding("UTF-8");

    String userid = request.getParameter("userid");// 참조변수는 같아야함
    String userpwd = request.getParameter("userpwd");//데이터를 서버로 가져오는 request
    String username = request.getParameter("username");//항상 문자로 가져감
    String state = request.getParameter("state");
    //하나의 변수에 값이 여러개 일때
    String[] hobby = request.getParameterValues("hobby"); 
    //전화번호
    String[] tel1 = request.getParameterValues("tel1");
    String tel2 = request.getParameter("tel2");
    String tel3 = request.getParameter("tel3");

    String num = request.getParameter("num");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=userid%><br/>  <!--=은 응답-->
비밀번호 : <%= userpwd %><br/>
이름 : <%=username%><br/>
동의여부 : <%= state%><br/> 
취미 : <%=Arrays.toString(hobby)%><br/>
연락처 : <%=tel1%>-<%=tel2%>-<%= tel3%><br/><!-- 프론트와 백앤드가 같이 있으면 백엔드가 먼저.-->
연락처 : <%=Arrays.toString(tel1)%>-<%=tel2%>-<%= tel3%><br/>
번호 : <%= num%>

<ul>
<%
//폼의 name을 구한다. 여긴 자바 영역
Enumeration<String> nameList = request.getParameterNames();
while(nameList.hasMoreElements()){
    %>
        <li><%= nameList.nextElement()%></li>

    <%
}
%>
</ul>
<ol>
<li>접속자의 ip : <%=request.getRemoteAddr()%></li>
<li>인코딩 코드값 : <%=request.getCharacterEncoding() %> </li>
<li>contentType:<%= request.getContentType() %></li>
<li> 전송방식 : <%=request.getMethod() %></li>
<li> protocol : <%= request.getProtocol()%></li>
<li>URI: <%=request.getRequestURI() %></li> <!-- 실행되고 있는 파일에대한 경로-->
<li>ContextPath: <%=request.getContextPath()%></li><!--wepjsp-->
<li>서버이름 : <%= request.getServerName()%></li>
<li>포트 : <%= request.getServerPort()%></li>
<li>절대주소 : <%= request.getServletContext().getRealPath("/") %></li><!-- 자바 서버를 만드는 클래스 servlet 원래는 서블렛을 실행
                                                                        jsp to java class and execute by tomcat            -->
<!---->
</ol>
</body>
</html>