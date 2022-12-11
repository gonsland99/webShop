<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath}/test/login3.do" method="post">
		<table width="400">
			<tr><td>아이디 <input type="text" name="id" size="10"/></td></tr>
			<tr><td>이름 <input type="text" name="name" size="10"/></td></tr>
			<tr>
				<td>
					<input type="submit" value="로그인"/>
					<input type="reset" value="다시작성"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>