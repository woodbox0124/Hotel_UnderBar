<%@page import="java.text.DateFormat"%>
<%@page import="com.dto.ResvMyDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.ResvDTO"%>
<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
<!-- 글꼴 -->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<!-- 글꼴 -->

<!-- resvMy css 시작 -->
<link rel="stylesheet" type="text/css" href="assets/css/resvMy.css">
<!-- resvMy css 끝 -->

<!-- 부트스트랩 css 시작 -->
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap-4.1.2/bootstrap.min.css">
<!-- 부트스트랩 css 끝 -->

<!-- jQuery 시작 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

 $(function() {
     $(".cancel").click(function() {
        var seq = $(this).attr("data-xxx");
        if(confirm("취소하시겠습니까?")){
        	alert("취소되었습니다.");
        	location.href="ResvCancle?seq="+seq;
          }
     })   
 });
 
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
<!-- jQuery 끝-->

<title>예약확인</title>
<meta charset="utf-8">

<%
	String mesg = (String) session.getAttribute("mesg");
if (mesg != null) {
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
	MemberDTO mdto = (MemberDTO) session.getAttribute("login");
String mu_id = mdto.getU_id();
String mu_name = mdto.getU_name();
%>

<body>
	<div id="main">
		<form action="#" id="form">

			<table class="resvmy" id="resvmy">
				<tr>
					<td colspan="11" id="resv_name"><%=mu_name%>님의 예약 정보</td>
				</tr>
				<tr>
					<th id="seq">예약번호</th>
					<th id="rating">평점</th>
					<th id="hotelname">호텔이름</th>
					<th id="roomname">룸 종류</th>
					<th id="checkin">체크인 날짜</th>
					<th id="checkout">체크아웃 날짜</th>
					<th id="resvdate">예약날짜</th>
					<th id="guest">인원 수</th>
					<th id="price">가격</th>
					<th id="test">수정</th>
					<th id="cancel">취소</th>

				</tr>
				<%
					List<ResvMyDTO> list = (List<ResvMyDTO>) request.getAttribute("resvMy");
				for (int i = 0; i < list.size(); i++) {
					ResvMyDTO dto = list.get(i);

					int seq = dto.getSeq();
					double rating = dto.getRating();
					String hotelname = dto.getHotelname();
					String addr = dto.getAddr();
					String roomname = dto.getRoomname();
					String checkin = dto.getCheckin();
					String checkout = dto.getCheckout();
					String resvdate = dto.getResvdate();
					int guest = dto.getGuest();
					int price = dto.getPrice();
					int cancel = dto.getCancel();

					if (cancel == 0) {
				%>

				<tr>

					<td><%=seq%></td>
					<td><%=rating%></td>
					<td><%=hotelname%></td>
					<td><%=roomname%></td>
					<td><%=checkin%></td>
					<td><%=checkout%></td>
					<td><%=resvdate%></td>
					<td><%=guest%></td>
					<td><%=price%></td>


					<td>
						<button type="button" class="btn btn-outline-primary"
							style="margin-bottom: 15px">수정</button>
					</td>
					<td>
						<button type="button" class="btn btn-outline-primary cancel"
							style="margin-bottom: 15px" data-xxx="<%=seq%>">취소</button>
					</td>
				</tr>
				<%
					}
				}
				%>


			</table>

		</form>

	</div>

</body>
</html>