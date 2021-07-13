<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>로그인창</title>
	<c:choose>
		<c:when test="${result == 'loginFailed' }">
			<script>
				window.onload=function(){
					alert("아이디나 비밀번호가 틀립니다 다시 로그인하세요");
				}
			</script>
		</c:when>
	</c:choose>
</head>
<body>
	<form action="${contextPath }/member/login.do" method="post">
	<table border="1" text-align="center">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
		</tr>
		<tr>
			<td><input type="text" name="id"/></td>
			<td><input type="password" name="pw"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="로그인"/><input type="reset" value="다시쓰기"/></td>
		</tr>
	</table>
	</form>
</body>
</html>