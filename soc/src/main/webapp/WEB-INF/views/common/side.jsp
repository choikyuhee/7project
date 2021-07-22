<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>사이드 메뉴</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
	
		.no-underline{
			text-decoration:none;
		}
	</style>
</head>
<body>
<div class="container" id="sidebar">
		<c:choose>
			<c:when test="${isLogOn == true && member != null }">
				<p>환영합니다. ${member.u_id }님</p>
				<a href="${contextPath }/member/login.do" class="no-underline">	</a>
				<a class = "no-underline" href="${contextPath }/member/logout.do"><strong>로그아웃</strong></a><br>
				<br>
				<a class ="btn btn-primary btn-sm" href="#" role="button">장바구니</a>
				&nbsp;
				<a class="btn btn-primary btn-sm" href="${contextPath }/member/mypageForm.do" role="button">마이페이지</a><br>
				</c:when>
				<c:otherwise>
					<a class = "no-underline" href="${contextPath }/member/loginForm.do"><strong>로그인</strong></a><br>
				</c:otherwise>
			</c:choose>
	
		<br>
		<a class="btn btn-primary" href="${contextPath }/member/joinForm.do" role="button">회원가입</a>
		<br>
		<br>
		<a href="${contextPath }/list.do" class="no-underline">회원관리</a><br>
		<br>
		<a href="#" class="no-underline">상품관리</a><br>
</div>
</body>
</html>