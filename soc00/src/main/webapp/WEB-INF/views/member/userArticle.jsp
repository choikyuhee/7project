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
	<title>작성글 보기</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
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
		<h3>작성글보기</h3>
		<hr/>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="osArticle" items="${osList }">
			<tr align="center" >
				<td>${osArticle.category}</td>
				<td>${osArticle.no }</td>
				<td><a href="${contextPath}/board/osView.do?no=${osArticle.no}">
					${osArticle.title }</a>
				</td>
				<td>
					<fmt:formatDate value="${osArticle.regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${osArticle.u_id }</td>
				<td>${osArticle.view }</td>
				<td><a role="button" id="del" class="btn btn-danger" href="${contextPath }/board/osDelete.do?no=${osArticle.no }">삭제하기</a></td>
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="krArticle" items="${krList }">
			<tr align="center" >
				<td>${krArticle.category}</td>
				<td>${krArticle.no }</td>
				<td><a href="${contextPath}/board/krView.do?no=${krArticle.no}">
					${krArticle.title }</a>
				</td>
				<td>
					<fmt:formatDate value="${krArticle.regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${krArticle.u_id }</td>
				<td>${krArticle.view }</td>
				<td><a role="button" id="del" class="btn btn-danger" href="${contextPath }/board/krDelete.do?no=${krArticle.no }">삭제하기</a></td>
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="newsArticle" items="${newsList }">
			<tr align="center" >
				<td>${newsArticle.category}</td>
				<td>${newsArticle.no }</td>
				<td><a href="${contextPath}/board/newsView.do?no=${newsArticle.no}">
					${newsArticle.title }</a>
				</td>
				<td>
					<fmt:formatDate value="${newsArticle.regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${newsArticle.u_id }</td>
				<td>${newsArticle.view }</td>
				<td><a role="button" id="del" class="btn btn-danger" href="${contextPath }/board/newsDelete.do?no=${newsArticle.no }">삭제하기</a></td>
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="freeArticle" items="${freeList }">
			<tr align="center" >
				<td>${freeArticle.category}</td>
				<td>${freeArticle.no }</td>
				<td><a href="${contextPath}/board/freeView.do?no=${freeArticle.no}">
					${freeArticle.title }</a>
				</td>
				<td>
					<fmt:formatDate value="${freeArticle.regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${freeArticle.u_id }</td>
				<td>${freeArticle.view }</td>
				<td><a role="button" id="del" class="btn btn-danger" href="${contextPath }/board/freeDelete2.do?no=${freeArticle.no }">삭제하기</a></td>
			</tr>
			
			</c:forEach>
		</table>
	</div>
</body>
</html>