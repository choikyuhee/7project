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
	<title>1:1문의</title>
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
		<h3>1:1문의</h3>
		<hr/>
		<br>
		<p>카테고리${question.q_category}</p>
		<p>글번호${question.q_no }</p>
		<p>글제목${question.q_title }</p>
		<p>글제목${question.q_content }</p>
		<p>등록일${question.q_regdate }</p>
		<p>작성자${question.u_id }</p>
		<p>조회수${question.q_view }</p>
		<hr/>
		<p id="a1">
		<a id="a1" class="btn btn-primary" href="#">글쓰기</a>
		</p>
		<br>

	</div>
</body>
</html>