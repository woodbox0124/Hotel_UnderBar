<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dto.RoomDTO"%>
<%@ page import="java.util.List"%>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<!-- 글꼴 CSS 시작-->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<!-- 글꼴 CSS 끝-->
<style type="text/css">
* {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
}
.cards {
	width: 1200px;
	height:600px;
	margin:0 auto;
	
}

.cards .card {
	width: 450px;
	height: 500px;
	margin: 30px;
	float:left;
	
}

#aa{
	margin:0 auto;
	width:1020px;
	height:100%;
}
img {
	width: 100%;
	height: 100%;
}
#wrapper{
	width:100%;
	
}
#resv{
    font-size: 20px;
    position: absolute;
    right: 10px;
    bottom: 14px;
    color:#000;
}
/* footer */
#footer {
	overflow: hidden;
	width: 100%;
	height: 260px;
}

.sns_box {
	width: 56px;
	height: 25px;
	margin: 0 auto;
}

.sns_box>a {
	width: 25px;
	display: inline-block;
	float: left;
	margin: 0 1.5px;
}

#certy {
	width: 1200px;
	margin: 0 auto;
	text-align: center;
}

.foo {
	float: left;
	margin: 20px 30px;
	text-align: left;
}

#footer_wrap {
	width: 1200px;
	height: 260px;
	margin: 0 auto;
	text-align: center;
}
</style>
<script type="text/javascript">

	var bDisplay = true;
    function doDisplay() {
        var con = document.getElementById("myDIV");
        if(con.style.display == 'block'){
            con.style.display = 'none';
        }else{
            con.style.display = 'block';
        }
    }  	

</script>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<div id="wrapper">
	<div class="cards">
	<div id="aa">
		<% 
	String checkin = (String)session.getAttribute("checkin");
	String checkout = (String)session.getAttribute("checkout");
	String location = (String)session.getAttribute("location");
	String guest = (String)session.getAttribute("guest");
	
	MemberDTO dto2 = (MemberDTO)session.getAttribute("login");
	String u_id = dto2.getU_id();
	


List<RoomDTO> list = (List<RoomDTO>)request.getAttribute("roomlist");
for(int i=0; i<list.size(); i++){
	RoomDTO dto = list.get(i);
	
	String seq = dto.getSeq();
	String name = dto.getName();
	String hotelseq = dto.getHotelseq();
	int price = dto.getPrice();
	int max_guest = dto.getMax_guest();
	String room_img = dto.getRoom_img();
	String room_img_real = dto.getRoom_img_real();

%>

		<div class="card">
			<img src="images/room/<%= room_img %>.jpg" class="card-img-top"
				alt="...">
			<div class="card-body">
				<h5 class="card-title"><%= name %></h5>
				<p class="card-text">
					<span id="price">가격 <%= price %></span>
				</p>
				<a href="RoomReservServlet?u_id=<%=u_id %>&checkin=<%=checkin%>&checkout=<%=checkout%>
                &guest=<%=guest%>&hotelseq=<%=hotelseq%>&roomseq=<%=seq%>&price=<%=price%>&location=<%=location%>" id="resv">바로예약</a>
				<ul>
					<li><a href="RoomInfoServlet?seq=<%=seq%>"
						style="color: black">객실 정보 자세히보기</a><br>
				</ul>
			</div>
		</div>

		<%} %>
		</div>
		
</div><!-- end cards  -->
</div>
	<!--  footer  -->
<div id="footer" style="background: #C0847F; color: #F8F4F0; font-weight: lighter;  padding: 15px 0; position: relative;">
	<div id="footer_wrap">
		<div style="font-size: 12px; display: inline-block;">
			<div class="foo_left foo">
				<ul>
					<li class="cs_center"><strong>010-9770-5298</strong></li>
					<li class="bank_info"><strong>110-354-583312</strong></li>
					<li>신한은행 <br>예금주 : 이석종(CEFO)
					</li>
					<li>고객센터 : 010-9770-5298<br>운영시간 10:00 ~
						17:00(점심 11:30 ~ 12:30)<br> 토,일,법정공휴일 휴무
					</li>
				</ul>
			</div>
			<ul class="foo_center foo">
				<li><b>회사명</b> : HotelUnderBar<b> 대표</b> : 이석종
				<li>
				<li><b>대표전화</b> : 010-9770-5298 <b>팩스</b>: 82-02-508-5765</li>
				<li><b>주소</b> : 서울특별시 강남구 테헤란로 124 삼원타워 5층</li>
				<li><b>사업자 번호</b>: 220-88-42280
				<li><b>개인정보관리책임자</b>: 이석종</li>
				<li><b>이메일</b> : 32popo@naver.com</li>
				<li><b>카카오톡 채널</b> : HotelUnderBar </li>
			</ul>
			<ul class="foo_right foo">
				<li><a href="#">개인정보처리방침</a><span class="line"></span></li>
				<li><a href="#">호텔이용안내</a><span class="line"></span></li>
				<li><a href="#">이용약관 </a><span class="line"></span></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</div>
		<div id="certy">
			HOTEL UNDERBAR [ Easy, Cool, Fancy ]
				<div class="copy en">ⓒ Copyright HOTEL UNDERBAR All Reserved</div>
			<div class="sns_box">
					<a href="https://www.facebook.com/woodbox0124" target="_blank">
						<img src="assets/css/images/fb.png">
					</a>
					<a href="https://www.instagram.com/woodcase/" target="_blank">
						<img src="assets/css/images/insta.png">
					</a>
			</div>
		</div>
	</div>
</div>
	
