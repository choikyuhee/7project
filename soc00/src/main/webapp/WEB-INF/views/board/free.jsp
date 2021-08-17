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
	<title>자유게시판</title>
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
		<h3>자유게시판</h3>
	
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
				
			</tr>
			<c:forEach var="freeArticle" items="${allList }">
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
				
			</tr>
			</c:forEach>
		</table>
		<hr/>
		<p id="a1">
		<a id="a1" class="btn btn-primary" href="${contextPath }/board/freeWriteForm.do">글쓰기</a>
		</p>
		<br>
		
		<div class="row">
		<div class="col-md-6" id="search2">
  			  <div class="input-group">
  			  	<select class="select">
  			  		<option>제목</option>
  			  		<option>작성자</option>
  			  		<option>제목+작성자</option>
  			  	</select>
  			    <input type="text" class="form-control" placeholder="내용을 입력하세요">
    			  <span class="input-group-btn">
       				 <button class="btn btn-default" type="button">검색</button>
    			  </span>
 			   </div><!-- /input-group -->
 		</div>
		</div>
		<br>
		<nav aria-label="Page navigation">
 			<ul class="pagination">
 			<c:if test="${page.prev }">
    			<li class="page-item">
      				<a class="page-link" href="${contextPath }/board/freeList.do?num=${page.startPageNum - 1 }" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
        			<span class="sr-only">Previous</span>
      				</a>
    			</li>
    		</c:if>
    		<c:forEach begin="${page.startPageNum }" end="${page.endPageNum }" var="num">
    		<c:if test="${select != num }">
    			<li class="page-item"><a class="page-link" href="${contextPath }/board/freeList.do?num=${num }">${num }</a></li>
    		</c:if>
    		<c:if test="${select == num }">
    			<li class="page-item active"><b class="page-link" >${num }</b></li>
    		</c:if>
			</c:forEach>
			<c:if test="${page.next }">
    			<li class="page-item">
      				<a class="page-link" href="${contextPath }/board/freeList.do?num=${page.endPageNum + 1}" aria-label="Next">
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