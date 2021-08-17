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
	<title>관리자 페이지</title>
	<meta charset="utf=8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<style>
		h3{text-align:center;}
	</style>
</head>
<body>

<div class="container">
<h3>관리자 페이지</h3>
<hr/>
	<div class="row">
		<div class="col">
			<a role="button" class="btn btn-primary" href="${contextPath }/member/userList.do" class="no-underline">회원목록</a><br>
		</div>
		<div class="col">
			<a role="button" class="btn btn-primary" href="${contextPath }/shop/prodRegForm.do" class="no-underline">상품등록</a><br>
		</div>
		<div class="col">
			<a role="button" class="btn btn-primary" href="${contextPath }/admin/shopList.do?num=1" class="no-underline">상품목록</a><br>
		</div>	
	</div>
</div>
</body>
</html>




