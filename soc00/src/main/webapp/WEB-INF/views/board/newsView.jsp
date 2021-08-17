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
	<title>뉴스</title>
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
		<h3>뉴스</h3>
		<hr/>
		<br>
	<table class="table table-hover">
		<tr>
			<td>제목</td>
			<td>${article.title }</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.u_id }</td>
			<td>작성일</td>
			<td><fmt:formatDate value="${article.regdate }" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>본문</td>
			<td>${article.content }</td>
		</tr>
	</table>
	<p id="a1">
		<c:if test ="${member.u_id == article.u_id || member.u_admin == 1 }">
			<a id="a1" class="btn btn-primary" href="${contextPath }/board/newsModiView.do?no=${article.no}">글수정</a>
			<a id="a1" class="btn btn-primary" href="${contextPath }/board/newsDelete.do?no=${article.no}">글삭제</a>
		</c:if>
		<a id="a2" class="btn btn-primary" href="${contextPath }/board/news.do?num=1">글목록</a>
	</p>
	
		<div class="reply">
		<c:forEach var="replyList" items="${replyList }">
				<p>${replyList.u_id } / <fmt:formatDate value="${replyList.r_regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				<p>${replyList.r_content }</p>
		</c:forEach>
		<c:choose>
			<c:when test="${isLogOn == true && member != null }">
				<form action="${contextPath }/board/insertNewsReply.do" method="post">
					<p>
					<input type="hidden" value="${member.u_id }" name="u_id" readonly/>
					</p>
					<p>
						<input type="hidden" value="${article.no }" name="no"/>
						<textarea cols="100" rows="3" name="r_content"></textarea>
						<button type="submit">댓글달기</button>
					</p>
				</form>
			</c:when>
			<c:otherwise>
				<p>로그인한 회원만 댓글을 작성할 수 있습니다</p>
			</c:otherwise>
		</c:choose>
		
		</div>
	</div>
	
</body>
</html>