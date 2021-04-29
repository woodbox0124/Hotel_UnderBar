<%@page import="java.text.DateFormat"%>
<%@page import="com.dto.ResvMyDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.ResvDTO"%>
<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<!--
	Aerial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<!-- 글꼴 -->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
<!-- 글꼴 -->
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<!-- table css 시작 -->
<style type="text/css">
*{
  font-family: 'twayair' , 'Roboto' ,'sans-serif' !important;	
 }

a {
	font-size: 40px;
	color: white;
}

.container th h1 {
	font-weight: bold;
	font-size: 1em;
	text-align: left;
	color: #185875;
}

.container td {
	font-weight: normal;
	font-size: 20px;
	-webkit-box-shadow: 0 2px 2px -2px #0E1119;
	-moz-box-shadow: 0 2px 2px -2px #0E1119;
	box-shadow: 0 2px 2px -2px #0E1119;
}

.container {
	text-align: left;
	overflow: hidden;
	width: 200%;
	margin: auto;
	display: table;
	padding: 0 0 8em 0;
}

.container td, .container th {
	padding-bottom: 2%;
	padding-top: 2%;
	padding-left: 0.3%;
	text-align: center;
}

/* Background-color of the odd rows */
.container tr:nth-child(odd) {
	background-color: #323C50;
}

/* Background-color of the even rows */
.container tr:nth-child(even) {
	background-color: #2C3446;
}

.container th {
	background-color: #1F2739;
}

.container td:first-child {
	color: #FB667A;
}

@media ( max-width : 800px) {
	.container td:nth-child(4), .container th:nth-child(4) {
		display: none;
	}
}

.update {
	color: black;
}
</style>
<!-- jQuery 시작 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
 $(function() {
	 $("#delete").click(function() {
		 var u_id = $(this).attr("data-xxx");
		 console.log(u_id);
		 location.href="MemberDeleteServlet?u_id="+u_id;
	 })	
});
</script>
<!-- jQuery 끝-->
<!-- table css 끝 -->
<title>예약확인</title>
<meta charset="utf-8">
<!-- main배경 css -->
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap-4.1.2/bootstrap.min.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<!-- main배경 css 끝 -->
<%
   String mesg = (String)session.getAttribute("mesg");
   if(mesg!=null){
%>
<script type="text/javascript">
     alert('<%=mesg%>');
   </script>
<%
session.removeAttribute("mesg");
   }
%>
</head>

<%
	  MemberDTO mdto = (MemberDTO)session.getAttribute("login");
    String mu_id = mdto.getU_id();
    String mu_name = mdto.getU_name();
%>    


<body class="is-preload">
	<div id="wrapper">
		<div id="bg"></div>
		<div id="overlay"></div>
		<div id="main">
			<nav class="hotelcol-1">
				<a href="MainServlet">Hotel UnderBar</a>
			</nav>
			<!-- Header -->
			<header id="header">
				<form action="MemberUpdateServlet">
					<table class="container">
						<tbody>
							<tr>
								<td colspan="2">
									<center>
										<h1><%=mu_name%>님의 예약정보
										</h1>
									</center>
								</td>
							</tr>
							<tr>

								<td>평점</td>
								<td>호텔이름</td>
								<td>룸 종류</td>
								<td>체크인 날짜</td>
								<td>체크아웃 날짜</td>
								<td>예약날짜</td>
								<td>인원 수</td>
								<td>가격</td>
								<td>수정</td>
							</tr>
							<% 		List<ResvMyDTO> list = (List<ResvMyDTO>)request.getAttribute("resvMy");
	for(int i = 0; i <list.size();i++)
	{
		ResvMyDTO dto = list.get(i);
		
		
		double rating = dto.getRating();
		String hotelname = dto.getHotelname();
		String addr = dto.getAddr();
		String roomname = dto.getRoomname();
		String checkin = dto.getCheckin();
		String checkout = dto.getCheckout();
		String resvdate = dto.getResvdate();
		int guest = dto.getGuest();
		int price = dto.getPrice();
	%>
							<tr>
								<td><%= rating %></td>
								<td><%=hotelname %></td>
								<td><%= roomname %></td>
								<td><%= checkin %></td>
								<td><%= checkout %></td>
								<td><%= resvdate %></td>
								<td><%= guest %></td>
								<td><%= price %></td>
								<td>
									<button type="button" class="btn btn-outline-primary"
										style="margin-bottom: 15px">수정</button>
								</td>
							</tr>
<%
  
	}
    %>
						</tbody>

					</table>



				</form>
				<div class="home_container">
					<div class="container">
						<div class="row">
							<div class="col">
								<div class="home_content text-center">
									<div
										class="d-flex flex-xl-row flex-column align-items-start justify-content-start">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</div>

		<div id="nav">
			<ul>
				<li><jsp:include page="../common/top.jsp" flush="false" /></li>
			</ul>
		</div>
		<script>
			window.onload = function() { document.body.classList.remove('is-preload'); }
			window.ontouchmove = function() { return false; }
			window.onorientationchange = function() { document.body.scrollTop = 0; }
		</script>
</body>
</html>