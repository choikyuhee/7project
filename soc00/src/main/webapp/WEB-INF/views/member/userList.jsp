<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>

<html>
<head>
	<meta charset="utf-8">
	<title>회원 정보 출력창</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<div class="container">
	<h3>회원목록</h3>
	<table class="table table" align="center" width="80%">
		<tr align="center">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>주소</b></td>
			<td><b>번호</b></td>
			<td><b>작성글보기</b></td>
			<td><b>구매내역</b></td>
			<td><b>삭제</b></td>
		</tr>
		<c:forEach var="member" items="${membersList }">
			<tr align="center">
				<td>${member.u_id }</td>
				<td>${member.u_pw }</td>
				<td>${member.u_name }</td>
				<td>${member.u_email}</td>
				<td>${member.u_address }</td>
				<td>${member.u_phone }</td>
				<td><a href="${contextPath }/admin/userArticle.do?u_id=${member.u_id}">작성글보기</a></td>
				<td><a href="">조회하기</a></td>
				<td><a role="button" class="btn btn-danger" href="${contextPath }/member/deleteMember.do?action=deleteMember&u_id=${member.u_id}">삭제하기</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>