<%@page import="com.dto.MemberDTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.ReviewDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<style type="text/css">
  summary {
    cursor: pointer;
  }

  summary {
    list-style: none;
  }
  summary::-webkit-details-marker {
    display: none;
  }
  
</style>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$(".sort").change(function () {
		console.log("sort 출력");
	})
	
	$(".update").click(function () {
		location.href="ReviewUpdateServlet";
	})
	
})
function reviewDelete(e, num) {
	e.preventDefault();
	location.href="ReviewDeleteServlet?num="+num;
}
function reviewWrite(hotelname) {
	location.href="ReviewWriteUIServlet?hotelname="+hotelname;
}

</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDTO mdto = (MemberDTO)session.getAttribute("login");
ReviewDTO dto1 = new ReviewDTO();
String hotelname = request.getParameter("hotelname");
System.out.print(hotelname);
String u_id1 = mdto.getU_id();
%>
<select class="sort">
	<option>등록순</option>
	<option>별점순</option>
</select>

<form class="review">	
<%
String u_name1 = mdto.getU_name();
List<ReviewDTO> list = (List<ReviewDTO>)request.getAttribute("reviewlist");
for(int i=0; i<list.size(); i++){
	ReviewDTO dto2 = list.get(i);
	String content = dto2.getContent();
	String title = dto2.getTitle();
	String writedate = dto2.getWritedate();
	String u_id2 = dto2.getU_id();
	int groupnum = dto2.getGroupnum();
	int num = dto2.getNum();
	int origin = dto2.getOrigin();
	double rating = dto2.getRating();
%>
<%
if(groupnum == 1){
%>
<img src='images/board/reply_icon.gif' />
<% 
}
%>	
<%=u_id2 %> : <%=rating %> <%=writedate %> 

<%
if(u_id1.equals(u_id2)){
%>
<input class="update" type="button" value="수정"> <input type="button" value="삭제" onclick="reviewDelete(event, <%=num%>)">
<%
}
%>


<details>
  <summary><%=title %></summary> 
  <p>이미지</p>
  <p><%=content%></p>
</details><br>	
<%
}
%>	
</form>		
<a href="ReviewWriteUIServlet?hotelname=<%=hotelname %>">작성</a>
</body>
</html>