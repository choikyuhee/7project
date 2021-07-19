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
<title>회원정보 수정</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
      
		.container{
			padding-top:20px;
			padding-bottom:50px;
		}
		h3{text-align:center;}
		#aa2{
			padding-left:45px;
		}
    </style>
</head>
<body>
<div class="container"> 
<h3 class="text-center">회원 정보 수정</h3>
<hr/>
<br>
  <form action="${contextPath }/member/modi.do" method="post">
<c:choose>
	<c:when test="${isLogOn == true && member != null }">
    <div class="col-md-4 offset-md-4" >
    	<input type="text" name="u_id" class="form-control" value="${member.u_id }" readOnly>
    </div>
</c:when>
</c:choose>
    <p></p>
    <div class="col-md-4 offset-md-4">
    	<input type="password" name="u_pw" class="form-control"  placeholder="비밀번호">
    </div>
    <p></p>
    <div class="col-md-4 offset-md-4">
    	<input type="passwordRe" class="form-control" placeholder="비밀번호확인">
    </div>
    <p></p>
    <div class="col-md-4 offset-md-4">
    	<input type="text" name="u_email" class="form-control" placeholder="이메일">
    <p></p>
    <p></p>
    </div>
    <div class="col-md-4 offset-md-4">
    	<input type="text" name="u_phone" class="form-control" placeholder="전화번호">
    </div>
    <p></p>
    <div class="col-md-4 offset-md-4">
    	<input type="text" name="u_address" class="form-control" placeholder="주소">
    </div>
    <p></p>
    <br>
<div class="row">
  <div id="aa1" class="col-md-1 offset-md-5" align="right">  
    <input type="submit" class="btn btn-primary" value="수정하기"/> 
	<span class="bar" aria-hidden="true"></span>
	</div>
	<div id="aa2" class="col-md-1" align="right">
	<a target="_blank" id="cancle" href="" class="btn btn-primary">취소</a> 
	<span class="bar" aria-hidden="true"></span>
  </div>
</div>
  </form>
</div> 
</body>
</html>
