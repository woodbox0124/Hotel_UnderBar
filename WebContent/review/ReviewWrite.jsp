<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="../jquery-ui-1.12.1/fontawesome-stars.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="../jquery-ui-1.12.1/jquery.barrating.min.js"></script>
<script type="text/javascript">
   $(function() {
      $('#star').barrating({
        theme: 'fontawesome-stars'
      });
   });
</script>

</head>
<body>
<%String hotelname=request.getParameter("hotelname");
%>
<form action="../ReviewWriteServlet" method="get" >
<input type="hidden" id="hotelname" name="hotelname" value="<%=hotelname%>">
<select id="star" name="star">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<% 
MemberDTO mdto = (MemberDTO) session.getAttribute("login");
String mu_id = mdto.getU_id();
%>
작성자(ID): <input type="text" name="u_id" id="u_id" value="<%=mu_id%>"><br>
제목: <input type="text" name="title" id="title"><br>
내용: <input type="text" name="content" id="content"><br>
<input type="file" id="file" name="file" class="image_inputType_file" accept="img/*">
<input type="reset" value="초기화">
<button class="btn btn-block btn-primary" type="submit">리뷰 등록</button>
</form>
</body>
</html>