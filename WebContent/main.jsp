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
<title>Aerial by HTML5 UP</title>
<meta charset="utf-8">
<!-- main배경 css -->
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />

<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<!-- main배경 css 끝 -->
<!-- 글꼴 CSS 시작 -->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<!-- 글꼴 CSS 끝 -->
<!-- 달력 쿼리  -->
<link rel="stylesheet" href="./jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="./jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>
<script type="text/javascript">
//<![CDATA[
$(function(){	
	$("#date1").datepicker({minDate: 0});
	$("#date2").datepicker({minDate: 0});
});
//]]>
</script>
<!-- 달력 쿼리 끝 -->
<%
   String mesg = (String)session.getAttribute("mesg");
		System.out.println(mesg);
   if(mesg!=null){
%>
<script type="text/javascript">
     alert('<%=mesg%>');
   </script>
<% 
session.removeAttribute("mesg");
}%>
<!-- 자체 CSS -->
<style type="text/css">
body {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
	color: white;
}
</style>
<!-- 자체 CSS 끝-->
</head>
<body class="is-preload">
	<jsp:include page="common/menu.jsp"></jsp:include>
	<div id="wrapper">
		<div id="bg"></div>
		<div id="overlay"></div>
		<div id="main">
			<!-- Header -->
			<header id="header">
							<div class="home_title">Hotel UnderBar</div>
							<div class="booking_form_container">
								<form action="HotelSearchServlet" class="booking_form">
									<div
										class="d-flex flex-xl-row flex-column align-items-start justify-content-start">
										<div
											class="booking_input_container d-flex flex-lg-row flex-column align-items-start justify-content-start">
											<div>
												<input type="text"
													class="datepicker booking_input booking_input_a booking_in"
													placeholder="체크인" required="required" id="date1"
													name="date1" autocomplete="off">
											</div>
											<div>
												<input type="text"
													class="datepicker booking_input booking_input_a booking_out"
													placeholder="체크아웃" required="required" id="date2"
													name="date2" autocomplete="off">
											</div>
											<div>
												<input type="number" class="booking_input booking_input_b"
													placeholder="인원 수" required="required" name="guest">
											</div>
											<div>
												<input type="text" class="booking_input booking_input_b"
													placeholder="지역" required="required" name="location">
											</div>
											<div>
												<button class="booking_button trans_200">검색</button>
											</div>
											</div>
								</form>
							</div>
						</div>
					</div>
		



	<script>
		window.onload = function() {
			document.body.classList.remove('is-preload');
		}
		window.ontouchmove = function() {
			return false;
		}
		window.onorientationchange = function() {
			document.body.scrollTop = 0;
		}
	</script>

</body>
</html>