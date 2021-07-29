<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
	h3{
		text-align:center;
	}
	.container{
		padding-top:20px;
	}
</style>
</head>

<body>
<div class="container" >
<h3>회원정보수정</h3>
<hr/>
<br>
		<nav class="navbar-expand">
			<ul class="navbar-nav">
				<li class="nav-item btn btn-sm btn-default"><a href="#">회원정보수정</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">작성글보기</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">구매내역조회</a>
			</ul>
		</nav>
		<br>
		<br>
<div class="row">
	<div class="col">
		<button class="btn btn-primary" onclick="location.href='${contextPath}/member/modiForm.do'">회원정보 수정</button>
	</div>
	<div class="col">
		<button class="btn btn-primary" onclick="location.href='#'">작성글보기</button>
	</div>
	<div class="col">
		<button class="btn btn-primary" onclick="location.href='${contextPath}/shop/orderList.do'">구매내역조회</button>
	</div>
</div>
</div>
</body>
</html>
