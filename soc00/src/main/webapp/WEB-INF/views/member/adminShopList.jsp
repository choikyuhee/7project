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
	<title>상품목록</title>
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
		<h3>상품목록</h3>
	
		<hr/>
		
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>상품번호</th>
				<th>이미지</th>
				<th>상품이름</th>
				<th>상품수량</th>
				<th>등록일</th>
				<th>수정하기</th>
				<th>삭제하기</th>
				
			</tr>
			<c:forEach var="shopArticle" items="${shopList }">
			<tr align="center" >
				<td>${shopArticle.p_no }</td>
				<td><img src="${contextPath }/${shopArticle.pr_filename}" width="30%"></td>
				<td><a href="${contextPath}/shop/prodInfo.do?p_no=${shopArticle.p_no}">
					${shopArticle.p_name }</a>
				</td>
				<td>${shopArticle.p_stock }</td>
				<td>
					<fmt:formatDate value="${shopArticle.p_regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td><a role="button" class="btn btn-primary" href="${contextPath}/shop/prodModiView.do?p_no=${shopArticle.p_no }">수정</a></td>
				<td><a role="button" class="btn btn-danger" href="${contextPath}/shop/deleteProd.do?no=${shopArticle.p_no}">삭제</a></td>
				
			</tr>
			</c:forEach>
		</table>
		<hr/>
		
		<br>
		<nav aria-label="Page navigation">
 			<ul class="pagination">
 			<c:if test="${page.prev }">
    			<li class="page-item">
      				<a class="page-link" href="${contextPath }/admin/adminShopList.do?num=${page.startPageNum - 1 }" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
        			<span class="sr-only">Previous</span>
      				</a>
    			</li>
    		</c:if>
    		<c:forEach begin="${page.startPageNum }" end="${page.endPageNum }" var="num">
    		<c:if test="${select != num }">
    			<li class="page-item"><a class="page-link" href="${contextPath }/admin/adminShopList.do?num=${num }">${num }</a></li>
    		</c:if>
    		<c:if test="${select == num }">
    			<li class="page-item active"><b class="page-link" >${num }</b></li>
    		</c:if>
			</c:forEach>
			<c:if test="${page.next }">
    			<li class="page-item">
      				<a class="page-link" href="${contextPath }/admin/adminShopList.do?num=${page.endPageNum + 1}" aria-label="Next">
        			<span aria-hidden="true">&raquo;</span>
        			<span class="sr-only">Next</span>
      				</a>
    			</li>
    		</c:if>
  			</ul>
		</nav>
	</div>
</body>
</html>