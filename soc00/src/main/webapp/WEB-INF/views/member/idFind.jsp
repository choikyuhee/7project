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
	<div class="container">	
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<p>아이디 : ${member.u_id } 입니다</p>
			</div>
			<div class="col"></div>
		</div>
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<button class="btn btn-primary" onclick="location.href='${contextPath}/member/loginForm.do'">
					로그인창으로 이동
				</button>
			</div>
			<div class="col"></div>
		</div>
		
		
	</div>
</body>

</html>
