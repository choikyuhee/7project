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
	<title>FAQ</title>
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
		<h3>FAQ</h3>
		<hr/>
		<br>
		<p>카테고리${faq.f_category}</p>
		<p>글번호${faq.f_no }</p>
		<p>글제목${faq.f_title }</p>
		<p>글제목${faq.f_content }</p>
		<p>등록일${faq.f_regdate }</p>
		<p>작성자${member.u_id }</p>
		<p>조회수${faq.f_view }</p>
		<hr/>
		<p id="a1">
			<c:if test ="${member.u_id == faq.u_id && member.u_admin == 1}">
				<a id="a1" class="btn btn-primary" href="${contextPath }/cs/faqModiView.do?f_no=${faq.f_no}">글수정</a>
				<a id="a1" class="btn btn-primary" href="${contextPath }/cs/faqDelete.do?f_no=${faq.f_no}">글삭제</a>
			</c:if>
			<a id="a2" class="btn btn-primary" href="${contextPath }/board/osSoccer.do">글목록</a>
		</p>
		<br>

	</div>
</body>
</html>