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
<meta charset="UTF-8">
<title>member join</title>
<style>
	.cls1{
		font-size: 40px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1 class="cls1">회원정보 수정</h1>
	<form method="post" action="${contextPath}/member/mod?id=${memInfo.id}">
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="id" value="${memInfo.id}" disable/></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</td>
				<td width="400"><input type="text" name="pw" value="${memInfo.pw}"/></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</td>
				<td width="400"><input type="text" name="name" value="${memInfo.name}"/></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</td>
				<td width="400"><input type="text" name="email" value="${memInfo.email}"/></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가입일</td>
				<td width="400"><input type="text" name="email" value="${memInfo.joinDate}" disable/></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="수정"/>
					<input type="reset" value="초기화"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>