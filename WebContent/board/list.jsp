<%@page import="com.dto.BoardPageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="com.dto.MemberDTO"%>
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

<meta charset="UTF-8">
<title>Q&#38;A 게시판</title>


<style type="text/css">
* {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
}

.listform{
	text-align: center;
	margin: 0 auto;
}
.normal{
	text-align: center;
}

#title{
margin-top: 20px;
margin-bottom: 10px;
}

#texttitle{
text-overflow: ellipsis; white-space: nowrap; max-width: 40px; /* 40px를 넘어가는 제목일 경우 "제목..."으로 표기됨 */
}

 .tablename:link { color: black; text-decoration: none;}	
 .tablename:visited { color: black; text-decoration: none;}	
 .tablename:hover { color: black; text-decoration: underline;}
 


</style>

</head>

<body>
<div class="container">
<h3 id="title" align="center" style="font-weight: bold;"><a class="tablename" href="BoardListServlet">게시글 목록</a></h3>
<table id="search" class="table table-hover">
	<tr>
	 <td colspan="5">
	  <form action="BoardListServlet" style="text-align: right; margin-right: 10px;">
	   <select name="searchName">
	    <option value="title">제목</option>
	    <option value="author">작성자</option>
	   </select>
	    <input type="text" name="searchValue">
	    <input type="submit" value="검색">
	 </form>  
	 </td> 
	</tr>
	<tr style="background: #0D6EFD; color: white; font-weight: bold" align="center">
		<td width="50">번호</td>
		<td width="220">제 목</td>
		<td width="100">작성자</td>
		<td width="100">작성일</td>
		<td width="50">조회수</td>
	</tr>
	
<%
BoardPageDTO pDTO = (BoardPageDTO) session.getAttribute("list");

List<BoardDTO> list = pDTO.getList();

for (BoardDTO dto : list) {
	int num=dto.getNum();
	String title=dto.getTitle();
	String author=dto.getAuthor();
	String content=dto.getContent();
	String writeday=dto.getWriteday();
	int readcnt=dto.getReadCnt();
	int origin=dto.getOrigin();
	int groupnum=dto.getGroupnum();
	int grouplayer=dto.getGrouplayer();


	
%>

			
				
	<tbody>
			
				
	<tr>
		<td class="normal"><%=num %></td>
		<td align="left">
<% 
		
	for(int j=0;j<grouplayer;j++){
%>
		&nbsp;&nbsp;&nbsp;
<%
	}
	if(grouplayer!=0)
	{
%>		
	<img src='images/board/reply_icon.gif' />
<%
	}
%> 
		<a class="tablename" href="BoardRetrive?num=<%=num%>"><%=title %></a> </td>
		<td class="normal"><%=author %></td>
		<td class="normal"><%=writeday %></td>
		<td class="normal"><%=readcnt %></td>
	</tr>
		
	</tbody>
		

	<tr>
	<%} %>

		 <td> 
		   <%
		   String searchName = (String)request.getAttribute("searchName");
			String searchValue = (String)request.getAttribute("searchValue");
		        int curPage = pDTO.getCurPage();//현재페이지
		        int perPage = pDTO.getPerPage();//페이지당 게시물수 
				int totalCount = pDTO.getTotalCount();//전체 레코드 수
				int totalPage = totalCount/perPage;  //필요한 페이지 
				if(totalCount%perPage!=0) totalPage++;
		        for(int i=1; i<= totalPage; i++){
		          	if(i== curPage){
		          		out.print(i+"&nbsp;");
		          	}else{
out.print("<a href='BoardListServlet?curPage="+i+"&searchName="+searchName+"&searchValue="+searchValue+"'>"+i+"</a>&nbsp;"); 		          	}
		        }//end for
		   %>
		
		
		  </td>
		<td style="text-align: right;">
		<a  style="text-align: right;" class="btn btn-primary" href="BoardWriteUIServlet"  >글쓰기</a>		
</td>
</table>



	
</div>
</body>
</html>