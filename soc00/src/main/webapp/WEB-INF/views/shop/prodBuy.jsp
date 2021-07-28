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
	<title>상품결제</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		h3{
			text-align:center;
		}
		#ru1{
			text-align:right;
		}
		.container{
			padding-top:20px;
			padding-bottom:20px;
		}
	</style>
</head>
<body>
	<div class="container">
		<h3>상품결제</h3>
		<hr/>
		<table class="table table" >
			<tr>
				<th>상품정보</th>
				<th>옵션</th>
				<th>금액</th>
			</tr>
			<tr>
				<td>
					<a href="#"><img src="./image/korea.jpg" style="float:left;" alt="한국국대유니폼">
						<p style="color:black;">${prodInfo.p_name }</p></a>
				</td>
				<td>
					<p>사이즈 : ${prodInfo.p_option }</p>
				</td>
				<td>
					<p>가격 : ${prodInfo.p_price }</p>
				</td>
			</tr>
		</table>
		<hr/>
		<br>
		<form>
		<div class="row">
			<div style="width:50%; padding-left:20px">
				<h4>주문자 정보</h4>
				<div class="form-group row">
					<label class="col-md-4">주문자</label>
					<input type="text" id="name" height=""/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">연락처</label>
					<input type="text" id="name" height=""/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">이메일</label>
					<input type="text" id="name" height=""/>
				</div>
			</div>
			<div style="width:50%;">
				<h4>배송정보</h4>
				<div class="form-group row" >
					<label class="col-md-4">배송지</label>
					<input type="text" id="name" height=""/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">받는사람</label>
					<input type="text" id="name" height=""/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">연락처</label>
					<input type="text" id="name" height=""/>
				</div>
			</div>
		</div>	
		</form>
		<br>
		<h4>결제방법</h4>
		<hr/>
		<div>
			<p>무통장 입금<br>
			국민은행<br>
			계좌번호 : 000000-00-000000<br>
			예금주 : 000</p>
			<hr/>
		</div>
		<div class="row">
			<div class="col-md-6" style="text-align:right;">
				<button class="btn btn-defalut">주문하기</button>
			</div>
			<div class="col-md-6" style="text-align:left;">
				<button class="btn btn-default" type="submit">결제취소</button>
			</div>
		</div>
	</div>
</body>
</html>