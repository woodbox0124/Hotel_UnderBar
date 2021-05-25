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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDTO mdto = (MemberDTO)session.getAttribute("login");
List<ReviewDTO> list2 = (List<ReviewDTO>)session.getAttribute("reviewlist");
ReviewDTO dto = list2.get(0);
String hotelname = dto.getHotelname();
System.out.print(hotelname);
String u_id1 = mdto.getU_id();
%>
<form class="sort">
<select class="selectsort">
	<option value="최신순">최신순</option>
	<option value="오래된순">오래된순</option>
</select>
<input type="submit" value="변경">
</form>
<form class="review">	
<%
String u_name1 = mdto.getU_name();
int admin = mdto.getAdmin();
List<ReviewDTO> list = (List<ReviewDTO>)session.getAttribute("reviewlist");
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
	String img=dto2.getReview_img();
	
	
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
if(u_id1.equals(u_id2) && groupnum == 0){
%>
<input class="update" type="button" value="수정"> <input type="button" value="삭제" onclick="reviewDelete(event, <%=origin%>)">
<%
}
%>
<%
if(admin == 1 && groupnum == 0){
%>
<input class="answer" type="button" value="답글"> <input type="button" value="삭제" onclick="reviewAdminDelete(event, <%=num%>)">
<%
}else if(admin == 1 && groupnum == 1){
%>
<input class="update" type="button" value="수정"> <input type="button" value="삭제" onclick="reviewAdminDelete(event, <%=num%>)">
<%
}
%>
<details>
  <summary><%=title %></summary> 
  <img src="reviewFolder/<%=img%>">
  <p><%=content%></p>
</details><br>	
<%
}
%>	
</form>		
<a href="ReviewWriteUIServlet?hotelname=<%=hotelname %>">작성</a>
<script type="text/javascript">
$(function () {
	$(".selectsort").change(function () {
		console.log($(this).val());
		if($(this).val() == "최신순"){
			$(".sort").attr("action","ReviewServlet");
		}
		if($(this).val() == "오래된순"){
			$(".sort").attr("action","ReviewOrderServlet");
		}
		})
		$(".update").click(function () {
			location.href="ReviewUpdateServlet";
	})
})
function reviewDelete(e, origin) {
	e.preventDefault();
	location.href="ReviewDeleteServlet?origin="+origin;
	alert("리뷰가 삭제 되었습니다");
}
function reviewAdminDelete(e, num) {
	e.preventDefault();
	location.href="ReviewDeleteServlet?num="+num;
	alert("리뷰가 삭제 되었습니다");
}
/* function reviewWrite(hotelname) {
	location.href="ReviewWriteUIServlet?hotelname="+hotelname;
} */
</script>
</body>
</html>