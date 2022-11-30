<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<ul class="list">
		<li>
			<span style='margin-left:50px'>이미지</span>
			<span>이미지명</span>
			<sapn>선택하기</sapn>
			<hr/>
		</li>
		<c:forEach var="i" begin="1" end="9" step="1">
		<li>
			<a href="#" style='margin-left:50px'>
				<img src='../../image/duke.png' width='90' height='90' alt=''/>
			</a>
			<a href="#"><strong>듀크${i}</strong></a>
			<a href="#"><input type="checkbox" name="chk${i}"/></a>
			<hr/>
		</li>
		</c:forEach>
	</ul>
</body>
</html>