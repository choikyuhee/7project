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
	<title>베스트</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
		crossorigin="anonymous"></script> <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> 
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
	<script> $('.carousel').carousel({
		interval: 2000 //기본 5초 }) 
	</script> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.container{
			padding-top:20px;
			padding-bottom:20px;
		}
		h3{
			text-align:center;
		}
		.carousel-inner > .carousel-item > img{ 
		width: 640px; height: 720px;
		}
	</style>
</head>
<body>
	<div class="container">
		<div id="demo" class="carousel slide" data-ride="carousel"> 
			<div class="carousel-inner"> 			
				<div class="carousel-item active"> <img class="d-block w-100" src="${contextPath }/resources/image/EPL.jpg" alt="First slide">
					<div class="carousel-caption d-none d-md-block"> 
						 
					</div> 
				</div> 
				<div class="carousel-item"> <img class="d-block w-100" src="${contextPath }/resources/image/son.png" alt="Second slide" > </div> 
				<div class="carousel-item"> <img class="d-block w-100" src="${contextPath }/resources/image/son2.jpg" alt="Third slide"> </div> 
				<a class="carousel-control-prev" href="#demo" data-slide="prev" > 
					<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
				</a> 
				<a class="carousel-control-next" href="#demo" data-slide="next"> 
					<span class="carousel-control-next-icon" aria-hidden="true"></span> 
				</a>
				<ul class="carousel-indicators"> 
					<li data-target="#demo" data-slide-to="0" class="active"></li> 
					<li data-target="#demo" data-slide-to="1"></li> 
					<li data-target="#demo" data-slide-to="2"></li> 
				</ul>
			</div>
		</div>
	</div>
</body>
</html>