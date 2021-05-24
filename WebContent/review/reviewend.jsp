<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
String rvmesg = (String) session.getAttribute("rvmesg");

if (rvmesg != null) {
%>
<script type="text/javascript">
 alert('<%=rvmesg%>');
 window.close();
</script>
<%
session.removeAttribute("rvmesg");
}
%>

</head>
<body>

</body>
</html>