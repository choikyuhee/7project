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
	<title>주문내역</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.container{
			padding-top:20px;
			padding-bottom:20px;
		}
		h3{
			text-align:center;
		}
		#a1{
			text-align:right;
		}
		.pagination{
			justify-content: center;
		}
		#search2{
			margin:auto;
			text-align:center;
		}
	</style>
</head>
<body>
	<div class="container">
		<h3>주문내역</h3>
		<hr/>
		<br>

		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>상품정보</th>
				<th>상품옵션</th>
				<th>금액</th>
			</tr>
			<c:forEach var="cartList" items="${cartList }">
			<tr align="center" >
				<td>${cartList.o_no}</td>
				<td><a href="${contextPath}/board/osView.do?no=${cartList.o_no}">${cartList.o_pname }</a>
					<fmt:formatDate value="${cartList.o_date }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatNumber value="${cartList.o_price }" pattern="###,###,###"/>원
				</td>
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<br>
		<div id="p0" class="row">
			<div id="p1" class="col-md-6">
				<p>총 상품금액</p>
				<p>15,000원</p>
			</div>
			<div id="p2" class="col-md-6">
				<p>금액</p>
				<p>15,000</p>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-6" style="text-align:right;">
				<button class="btn btn-defalut">쇼핑계속하기</button>
			</div>
			<div class="col-md-6" style="text-align:left;">
				<button class="btn btn-default" type="submit">주문하기</button>
			</div>
		</div>
	</div>
</body>
</html>