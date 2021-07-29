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
		<form action="${contextPath }/shop/buy.do" method="post" class="form-horizontal">
				<h4>구매자 정보</h4>
				<input type="text" name="o_pname" class="hidden" value="${prodInfo.p_name }"/>
				<input type="text" name="o_price" class="hidden" value="${prodInfo.p_price }"/>
				<input type="text" name="p_no" class="hidden" value="${prodInfo.p_no }"/>
				<div class="form-group row">
					<label class="col-md-4">이름</label>
					<input type="text" id="name" value="${member.u_name }" readonly/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">연락처</label>
					<input type="text" id="phone" value="${member.u_phone }" readonly/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">이메일</label>
					<input type="text" id="email" value="${member.u_email }" readonly/>
				</div>
				<h4>받는사람 정보</h4>
				<div class="form-group row">
					<label class="col-md-4">이름</label>
					<input type="text" name="o_name" value="${member.u_name }"/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">연락처</label>
					<input type="text" name="o_phone" value="${member.u_phone }"/>
				</div>
				<div class="form-group row" >
					<label class="col-md-4">배송지</label>
					<input type="text" name="o_address" value="${member.u_address }"/>
				</div>
				<div class="form-group row">
					<label class="col-md-4">요청사항</label>
					<input type="text" name="o_request" height=""/>
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
				<input type="submit" role="button" class="btn btn-defalut" value="주문하기"/>
			</div>
			<div class="col-md-6" style="text-align:left;">
				<input role="button" class="btn btn-default" type="reset" value="취소"/>
			</div>
		</div>
	</div>
</body>
</html>