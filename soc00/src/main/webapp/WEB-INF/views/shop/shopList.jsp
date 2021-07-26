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
<title>쇼핑몰</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
	.pagination{
			justify-content: center;
		}
	h3{
		text-align:center;
	}
	#search2{
			margin:auto;
			text-align:center;
		}
</style>
</head>

<body>
    
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
</svg>


<div class="container py-3">

  <main>
  <h3>축구몰</h3>
  <hr/>
  <nav class="navbar-expand">
		<ul class="navbar-nav">
				<li class="nav-item btn btn-sm btn-default"><a href="#">모두보기</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">유니폼</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">축구공</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">축구화</a>
				<li class="nav-item btn btn-sm btn-default"><a href="#">기타장비</a>
			</ul>
	</nav>
	<br>
    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
      
	<c:forEach var="shopList" items="${shopList }">
      <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
          <div class="card-body">
            <h3 class="card-title pricing-card-title">${shopList.p_name }<small class="text-muted fw-light"></small></h3>
            
            <img src="${contextPath }/resources/image/${shopList.p_filename }" style="max-width: 100%; height: auto;">
            
            <ul class="list-unstyled mt-3 mb-4">
              <li>${shopList.p_name }</li>
              <li>${shopList.p_option }</li>
              <li>${shopList.p_price }</li>
            </ul>
    
            <a role="button" class="w-100 btn btn-lg btn-primary" 
            	onclick="location.href='${contextPath}/shop/prodInfo.do?p_no=${shopList.p_no }'">구매하기</a>
          </div>
        </div>
    </div>
    <br>
    </c:forEach>
    </div>
    <br>
    <div class="row" >
		<div class="col-md-6" id="search2">
  			  <div class="input-group">
  			  
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
</main>
</div>
</body>
</html>