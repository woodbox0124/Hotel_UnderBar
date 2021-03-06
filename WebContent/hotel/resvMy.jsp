<%@page import="com.dto.ResvPageDTO"%>
<%@page import="com.dto.HotelDTO"%>
<%@page import="com.dto.PageDTO"%>
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
<%
					/* List<ResvMyDTO> list = (List<ResvMyDTO>) request.getAttribute("resvMy");
				for (int i = 0; i < list.size(); i++) {
					ResvMyDTO dto = list.get(i); */
					ResvPageDTO RpDTO = (ResvPageDTO)session.getAttribute("RpDTO");
					
					List<ResvMyDTO> list = RpDTO.getList();
					
					for (int i = 0; i < list.size(); i++){
					
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
<!-- 글꼴 -->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
<!-- 글꼴 -->

<!-- resvMy css 시작 -->
<link rel="stylesheet" type="text/css" href="assets/css/resvMy.css">
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
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
 
 $(function(){ //리뷰쓰기 팝업창구현
	 $("#a").click(function(){
		 var url= "review/ReviewWrite.jsp?hotelname=<%=hotelname%>";    
		 var name="popup test"
		 var option="width = 500, height=500, top=100,left=200";
		 window.open(url,name,option);
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
					<th id="cancel">취소</th>

				</tr>

				

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
						<button type="button" class="btn btn-outline-primary cancel"
							style="margin-bottom: 15px" data-xxx="<%=seq%>">취소</button>
						<button id="a">리뷰쓰기</button>
					</td>
				</tr>
				<%
					}
				}
				%>


			</table>

		</form>
		
		</div>
		
<div class="page">
		<%
			String u_id = (String)session.getAttribute("u_id");
			int curPage = RpDTO.getCurPage();//현재페이지
			int perPage = RpDTO.getPerPage();//페이지당 게시물수
			int totalCount = RpDTO.getTotalCount();//전체 레코드수 
			int totalPage = totalCount/perPage;// 필요한 페이지
			System.out.println(curPage);
			System.out.println(perPage);
			System.out.println(totalCount);
			System.out.println(totalPage);
	
			if(totalCount%perPage!=0) totalPage++;
			for(int i = 1; i <= totalPage; i++){
				if(i==curPage){
					System.out.print("if i"+i);
					out.print(i+"&nbsp;");
				}else{
					System.out.print("else i"+i);
					out.print("<a href='ResvMyServlet?curPage="+i+"&u_id="+u_id+"'>"+i+"</a>&nbsp;");
				}//end for		
			}
		%>
		
		
	</div>

</body>
</html>