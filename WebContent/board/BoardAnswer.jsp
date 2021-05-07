<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="com.dto.BoardDTO"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
	
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
	
	<style type="text/css">
* {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
}
tr, td{
padding-top: 5px;
padding-bottom: 5px;
border: 1px solid #444444;
}

#title{
margin-top: 20px;
margin-bottom: 10px;
}

#text{
margin-left: 25px;
}

</style>
	
<meta charset="UTF-8">
<title>Q&#38;A 게시판</title>
<script type="text/javascript">
function formcheck(e) {
	
	 var title= document.querySelector("#title").value;
	 var author= document.querySelector("#author").value;
	var content= document.querySelector("#content").value;
	console.log(title.length, author.length, content.length);
	if(title.length==0||author.length==0||content.length==0){
		alert("모든 내용을 작성해 주세요");
		event.preventDefault();
	}  
}
</script>
</head>
<body>
<%
BoardDTO dto=(BoardDTO)session.getAttribute("retrieve");
int num=dto.getNum();
String title=dto.getTitle();
String author=dto.getAuthor();
String content=dto.getContent();
String writeday=dto.getWriteday();
int readCnt=dto.getReadCnt();
int origin=dto.getOrigin();
int groupnum=dto.getGroupnum();
int grouplayer=dto.getGrouplayer();

%>
<h3 id="title" style="text-align: center;">Q&#38;A 게시판</h3>
<div class="container" >
<form action="BoardAnswerServlet" method="post" onsubmit="return formcheck()">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="groupnum" value="<%=groupnum%>">
    <input type="hidden" name="grouplayer" value="<%=grouplayer%>">
    <input type="hidden" name="origin" value="<%=origin%>">
	<table style="margin: 0 auto;" border="1">

		<tr>
			
			<td width="50" align="center">제목</td>
			<td width="330">
			<input type="text" name="title" id="title">
			</td>
		</tr>
		<tr>
			<td width="65" align="center">작성자</td>
			<td width="330">
			<input id="author" type="text" name="author" size="50" value="admin"> <!-- if로 인해 jstl 사용 -->
			</td>
		</tr>
		<tr>
			<td width="70" align="center">내용</td>
			<td width="330">
			<textarea id="content" rows="13" cols="50" name="content" style="resize: none;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input class="btn btn-primary" type="submit" value="답글쓰기">
			<input class="btn btn-primary" type="reset" value="다시작성"> 
			<a class="btn btn-primary" href="BoardListServlet">목록보기</a>
		</tr>
	</table> 
</form>
</div>
</body>
</html>