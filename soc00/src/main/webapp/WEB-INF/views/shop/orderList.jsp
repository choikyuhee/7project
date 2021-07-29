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
				<th>주문번호</th>
				<th>상품정보</th>
				<th>금액</th>
			</tr>
			<c:forEach var="orderList" items="${orderList }">
			<tr align="center" >
				<td>${orderList.o_no}</td>
				<td><a href="${contextPath}/board/osView.do?no=${orderList.o_no}">${orderList.o_pname }</a>
					<fmt:formatDate value="${orderList.o_date }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatNumber value="${orderList.o_price }" pattern="###,###,###"/>
				</td>
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<br>
	</div>
</body>
</html>