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
	<style>
		h3{text-align:center;}
	</style>
</head>
<body>
	<div class="container">
	<h3>주문내역 조회</h3>
	<hr/>
	<div class="row">
		<c:forEach var="orderView" items="${orderView }">
		<div class="col">
		<p><img src="${contextPath }/${orderView.p_filename }" width="150px;"></p>
		<p>${orderView.p_name }</p>
		<p>수량 : ${orderView.od_count }</p>
		<p>${orderView.o_price } 원</p>
		<p>받는사람 : ${orderView.o_name }</p>
		<p>배송지 : ${orderView.o_address }</p>
		<p>연락처 : ${orderView.o_phone }</p>
		<p>배송 요청사항 : ${orderView.o_request }</p>
		</div>
	</c:forEach>
	</div>
	
	</div>
</body>
</html>