<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>formatNumber 예제</h2>
	<c:set var="price" value="1000000"/>
	<fmt:formatNumber value="${price}" type="number" var="priceNumber"/>
	일반 표현 : ${priceNumber}<br/>
	통화 표현 : 
	<fmt:formatNumber value="${price}" type="currency" currencySymbol="￦" groupingUsed="true"/> <br/>
	퍼센트 표현 :
	<fmt:formatNumber value="${price}" type="percent" groupingUsed="false"/> <br/>
	<h2>formatDate 예제</h2>
	<c:set var="now" value="<%=new Date()%>"/>
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br/>
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br/>
	<fmt:formatDate value="${now}" type="time"/><br/>
	<fmt:formatDate value="${now}" pattern="YYYY-MM-dd :hh:mm:ss"/><br/>
	한국시간: 
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/>
	<fmt:timeZone value="America/New York">
		미국시간: 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/>
	</fmt:timeZone>
</body>
</html>