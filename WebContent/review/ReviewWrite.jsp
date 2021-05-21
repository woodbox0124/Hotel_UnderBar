<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%String hotelname=request.getParameter("hotelname"); %>
<body>
<form action="../ReviewWriteServlet" method="get" onsubmit="return formcheck()">
<input type="hidden" id="hotelname" name="hotelname" value="<%=hotelname%>">
제목: <input type="text" name="title" id="title"><br>
작성자: <input type="text" name="u_id" id="u_id"><br>
내용: <input type="text" name="content" id="content"><br>
<input type="submit" value="제출">
</form>
</body>
</html>