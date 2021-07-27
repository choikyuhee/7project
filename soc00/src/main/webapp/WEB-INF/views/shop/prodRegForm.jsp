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
	<title>상품등록</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h3>상품등록</h3>
<hr/>
	<form action="${contextPath }/shop/prodReg.do" method="post" class="form-horizontal">
		<div class="form-group row">
			<label class="col-sm-2">상품이름</label>
			<div class="col-sm-3">
				<input type="text" name="p_name" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상품가격</label>
			<div class="col-sm-3">
				<input type="text" name="p_price" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상품 카테고리</label>
			<div class="col-sm-3">
				<select class="form-control" name="p_category">
	  				<option>유니폼</option>
	  				<option>축구공</option>
	  				<option>축구화</option>
	  				<option>기타장비</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상품정보</label>
			<div class="col-sm-5">
				<textarea name="p_content" cols="50" rows="2" class="form-control"></textarea>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">상품사이즈</label>
			<div class="col-sm-3">
				<select class="form-control" name="p_option">
	  				<option>M</option>
	  				<option>L</option>
	  				<option>XL</option>
	  				<option>기타장비</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">재고</label>
			<div class="col-sm-3">
				<input type="text" name="p_stock" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10 offset-sm-2">
				<input type="submit" class="btn btn-primary" value="등록"/>
			</div>
		</div>
	</form>
</div>
</body>

</html>