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
	<title>고객센터</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.container{
			padding-top:20px;
			padding-bottom:20px;
		}
		h3{
			text-align:center;
		}
		
		h5{
			text-align:center;
		}
		
		#a1{
			text-align:right;
		}
		#a2{
			text-align:center;
		}
		#b1{
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
		<h3>고객센터</h3>
		<hr/>
		<h3>고객센터 전화번호 0000-0000</h3>
		<h5>운영시간 / 10:00 ~ 17:00 / 점심시간 12:00 ~ 13:00/ 토, 일 공휴일은 쉽니다.</h1> 
		
		<br>
		<nav class="navbar-expand">
			<ul class="navbar-nav">
				<li class="nav-item btn btn-sm btn-default"><a href="#">결제</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">회원</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">배송</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">상품</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">기타</a>
			</ul>
			<p id="a1"><a id="a1" class="btn btn-primary btn-lg" 
				href="${contextPath }/cs/question.do">1:1문의</a></p>
		</nav>
		<br>
		<table class="table table-hover">
			<tr align="center">
				<th>카테고리</th>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
			<c:forEach var="faqList" items="${faqList }">
			<tr align="center">
				<td>${faqList.f_category }</td>
				<td>${faqList.f_no }</td>
				<td><a href="${contextPath}/cs/faqView.do?f_no=${faqList.f_no}">
					${faqList.f_title }</a>
				</td>
				<td>${faqList.u_id }</td>
				<td>
					<fmt:formatDate value="${faqList.f_regdate }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${faqList.f_view }</td>
			</tr>
			</c:forEach>
			
		</table>
		<hr/>
			<c:if test="${isLogOn == true && member.u_admin == 1 }">
				<button id="b1" class="btn btn-primary" onclick="location.href='${contextPath}/cs/faqWriteForm.do'">글쓰기</button>
			</c:if>
		<br>
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
 			   </div>
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