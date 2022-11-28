<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	toString<br/>
	<h2><%=exception.toString() %></h2>
	getMessage<br/>
	<h2><%=exception.getMessage() %></h2>
	printStackTrace<br/>
	<h2><% exception.printStackTrace(); %></h2>
	<h3>숫자만 입력가능 <a href='add.html'>다시 계산</a></h3>
</body>
</html>