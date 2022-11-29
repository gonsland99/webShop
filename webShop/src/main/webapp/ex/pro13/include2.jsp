<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	header
	<br>
	<jsp:include page="image.jsp" flush="true">
		<jsp:param name="name" value="듀크2"/>
		<jsp:param name="imgName" value="duke2.png"/>
	</jsp:include>
	<br>
	footer
</body>
</html>