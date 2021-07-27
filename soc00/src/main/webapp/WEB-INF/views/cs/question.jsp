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
	<title>1:1문의 게시판</title>
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
		<h3>1:1문의 게시판</h3>
		<hr/>
		<br>
		<nav class="navbar-expand">
			<ul class="navbar-nav">
				<li class="nav-item btn btn-sm btn-default"><a href="#">결제</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">회원</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">배송</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">상품</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">기타</a>
			</ul>
		</nav>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
		
			<c:forEach var="qnaList" items="${qnaList }">
			<tr align="center">
				<td>${qnaList.q_category }</td>
				<td>${qnaList.q_no }</td>
				<td><a href="${contextPath}/cs/qnaView.do?q_no=${qnaList.q_no}">
					${qnaList.q_title }</a>
				</td>
				<td>${qnaList.u_id }</td>
				<td>
					<fmt:formatDate value="${qnaList.q_regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${qnaList.q_view }</td>
			</tr>
			</c:forEach>
			
		</table>
		<hr/>
		<p id="a1">
		<a id="a1" class="btn btn-primary" href="${contextPath }/cs/qnaWriteForm.do">글쓰기</a>
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
    			<li class="page-item">
      				<a class="page-link" href="#" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
        			<span class="sr-only">Previous</span>
      				</a>
    			</li>
    			<li class="page-item"><a class="page-link" href="#">1</a></li>
    			<li class="page-item"><a class="page-link" href="#">2</a></li>
    			<li class="page-item"><a class="page-link" href="#">3</a></li>
    			<li class="page-item"><a class="page-link" href="#">4</a></li>
    			<li class="page-item"><a class="page-link" href="#">5</a></li>
    			<li class="page-item">
      				<a class="page-link" href="#" aria-label="Next">
        			<span aria-hidden="true">&raquo;</span>
        			<span class="sr-only">Next</span>
      				</a>
    			</li>
  			</ul>
		</nav>
		
	</div>
</body>
</html>