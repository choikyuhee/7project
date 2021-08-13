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
	<title>주문 상세보기</title>
</head>
<body>
	<div class="container">
	<c:forEach var="orderView" items="${orderView }">
		<p><img src="${contextPath }/${orderView.p_filename }"></p>
		<p>${orderView.p_name }</p>
	</c:forEach>
	</div>
</body>
</html>