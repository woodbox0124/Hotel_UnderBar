<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.ReviewDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	
<%
List<ReviewDTO> list=(List<ReviewDTO>)request.getAttribute("reviewlist");

%>
리스트 받아와서 뿌려주기<br>
			
평점 제목<br>
후기내용<br>
날짜 | 유저아이디
				
	
		


</body>
</html>