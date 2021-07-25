<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ID 찾기</title>
</head>
<body>
	<div class="contanier">
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<p>아이디는 ${member.u_id } 입니다</p>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<div class="row">
			<div class="col"></div>
			<div class="col">
				<button onclick="location.href='${contextPath}/member/loginForm.do'" class="btn btn-primary">로그인하기</button>
			</div>
			<div class="col"></div>
		</div>
</body>

</html>