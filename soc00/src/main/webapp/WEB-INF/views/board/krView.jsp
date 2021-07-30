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
	<title>해외축구</title>
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
		<h3>국내축구</h3>
		<hr/>
		<br>
	<table class="table table-hover">
		<tr style="width=100%;">
			<td >제목</td>
			<td>${article.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.u_id }</td>
			<td>작성일</td>
			<td><fmt:formatDate value="${article.regdate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>${article.content }</td>
		</tr>
	</table>
		<p>카테고리${article.category}</p>
		<p>글번호${article.no }</p>
		<p>글제목${article.title }</p>
		<p>글제목${article.content }</p>
		<p>등록일${article.regdate }</p>
		<p>작성자${article.u_id }</p>
		<p>조회수${article.view }</p>
		<hr/>
		<p id="a1">
		<a id="a1" class="btn btn-primary" href="#">글쓰기</a>
		</p>
		<br>

	</div>
</body>
</html>