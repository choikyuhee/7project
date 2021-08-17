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
	<title>장바구니</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
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
		#thumb{
			width:100px;
		}
		.allCheck{
			float:left;
			padding-left:30px;
		}
		
		.orderInfo { border:5px solid #eee; padding:20px; display:none;}
		.orderInfo .inputOrder { margin:10px 0; }
		.orderInfo .inputOrder label { display:inline-block; width:120px; margin-right:10px; }
		.orderInfo .inputOrder input { font-size:14px; padding:5px; }
		#o_address { width:250px; }
		
		.orderInfo .inputOrder:last-child { margin-top:30px; }
		.orderInfo .inputOrder button { font-size:20px; border:2px solid #ccc; padding:5px 10px; background:#fff; margin-right:20px;}
	</style>
</head>
<body>

	<div class="container">
		<h3>장바구니</h3>
		
		<hr/>
		<br>
		  <div class="allCheck">
		   <input type="checkbox" name="allCheck" id="allCheck" /><label for="allCheck">모두 선택</label> 
		   	  <script>
				$("#allCheck").click(function(){
				 var chk = $("#allCheck").prop("checked");
				 if(chk) {
				  $(".chBox").prop("checked", true);
				 } else {
				  $(".chBox").prop("checked", false);
				 }
				});
			</script>
		  </div>
		  <div class="delBtn">
		   <button type="button" class="selectDelete_btn">선택 삭제</button> 
		   <script>
			 $(".selectDelete_btn").click(function(){
			  var confirm_val = confirm("정말 삭제하시겠습니까?");
			  
			  if(confirm_val) {
			   var checkArr = new Array();
			   
			   $("input[class='chBox']:checked").each(function(){
			    checkArr.push($(this).attr("data-cartNum"));
			   });

			   $.ajax({
			    url : "${contextPath}/shop/deleteCart.do",
			    type : "post",
			    data : { chbox : checkArr },
			    success : function(){
			     location.href = "${contextPath}/shop/cartList.do?u_id=${member.u_id}";
			    }
			   });
			  } 
			 });
			</script>
		  </div>
		
		<table class="table table-hover">
			<tr align="center">
				<th></th>
				<th>상품</th>
				<th>상품정보</th>
				<th>상품옵션</th>
				<th>금액</th>
			</tr>
			<c:set var="sum" value="0"/>
			<c:forEach var="cartList" items="${cartList }">
			<tr>
				<td>
					<div class="checkBox">
					   <input type="checkbox" name="chBox" class="chBox" data-cartNum="${cartList.c_no}" />
					 	<script>
						 $(".chBox").click(function(){
						  $("#allCheck").prop("checked", false);
						 });
						</script>
					 </div>
				</td>
				<td><a href="${contextPath}/shop/prodInfo.do?p_no=${cartList.p_no}">
					<img id="thumb" src="${contextPath}/${cartList.p_filename}"></a>
				</td>
				<td>
					<a href="${contextPath}/shop/prodInfo.do?p_no=${cartList.p_no}">
					${cartList.p_name }</a>
				</td>
				<td>
					<p>${cartList.p_option }</p>
					<p>${cartList.c_count }개</p>
				</td>
				<td>
					<fmt:formatNumber value="${cartList.p_price * cartList.c_count }" pattern="###,###,###"/>원
				</td>
			</tr>
			<c:set var="sum" value="${sum + (cartList.p_price * cartList.c_count) }"/>
			</c:forEach>
		</table>
		<hr/>
		<br>
		<div class="cartResult">
			총 <fmt:formatNumber value="${sum }" pattern="###,###,###"/> 원
		</div>
		<br>
		<div class="row">
			<div class="col-md-6" style="text-align:right;">
				<a role="button" class="btn btn-primary" href="${contextPath}/shop/shopList.do">쇼핑계속하기</a>
			</div>
			<div class="col-md-6" style="text-align:left;">
				<a role="button" id="asd" class="btn btn-primary">주문하기</a>
				<script>
					$("#asd").click(function(){
						$(".orderInfo").slideDown();
						
					})
				</script>
			</div>
		</div>
		<br>
		<div class="orderInfo">
		
		<form action="${contextPath }/shop/buy.do" method="post">
				<input type="hidden" name="u_id" value="${member.u_id }"/>
				<input type="hidden" name="o_price" value="${sum }"/>
				<h4>받는사람 정보</h4>
				<div class="inputOrder">
					<label>이름</label>
					<input type="text" id="o_name" name="o_name" />
				</div>
				<div class="inputOrder">
					<label>연락처</label>
					<input type="text" id="o_phone" name="o_phone" />
				</div>
				<div class="inputOrder" >
					<label >배송지</label>
					<input type="text" id="o_address" name="o_address" />
				</div>
				<div class="inputOrder">
					<label >요청사항</label>
					<input type="text" id="o_request" name="o_request"/>
				</div>
				<div class="inputOrder">
					<button type="submit" class="order_btn">주문</button>
					<button type="button" class="cancel_btn">취소</button> 
				</div>
				<script>
					$(".cancel_btn").click(function(){
						$(".orderInfo").slideUp();
						
					});      
				</script>
		</form>
		</div>
	</div>
</body>
</html>