<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, ex.pro17.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member list</title>
<style>
	.cls1{
		font-size: 40px;
		text-align: center;
	}
	.cls2{
		font-size: 20px;
		text-align: center;
	}
</style>
</head>
<body>
	<p class="cls1">회원정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
		</tr>
		<c:choose>
			<c:when test="${ empty memberList }">
			<tr>
				<td colspan=5>등록된 회원이 없습니다.</td>
			</tr>
			</c:when>
			<c:when test="${ !empty memberList }">
				<c:forEach var="m" items="${ memberList }">
				<tr align="center">
					<td>${ m.id }</td>
					<td>${ m.pw }</td>
					<td>${ m.name }</td>
					<td>${ m.email }</td>
					<td>${ m.joinDate }</td>
				</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="#">
		<p class="cls2">회원가입</p>
	</a>
</body>
</html>