<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<c:choose>
	<c:when test="${msg == 'addMember'}">
		<script>
			window.onload = function(){
				alert("회원정보 등록완료");
			}
		</script>
	</c:when>
	<c:when test="${msg == 'modified'}">
		<script>
			window.onload = function(){
				alert("회원정보 수정완료");
			}
		</script>
	</c:when>
	<c:when test='${msg == "deleted"}'>
		<script>
			window.onload = function(){
				alert("회원정보 삭제완료");
			}
		</script>
	</c:when>
	</c:choose>
<meta charset="UTF-8">
<title>member join</title>
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
			<td width="7%"><b>수정</b></td>
			<td width="7%"><b>삭제</b></td>
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
					<td><a href="${contextPath}/member/modMemberForm?id=${m.id}">수정</a></td>
					<td><a href="${contextPath}/member/del?id=${m.id}">삭제</a></td>
				</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="${contextPath}/member/memberForm">
		<p class="cls2">회원가입</p>
	</a>
</body>
</html>