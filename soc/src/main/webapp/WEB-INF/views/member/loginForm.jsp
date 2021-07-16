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
<title>login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
      .container{
      	padding-top:50px;
      	padding-bottom:50px;
      }
    </style>
	
	<c:choose>
		<c:when test="${result == 'loginFailed' }">
	
    <script type="text/javascript">
	    	window.onload=function(){
				alert("아이디나 비밀번호가 틀립니다 다시 로그인하세요");
			}
	</script>
	</c:when>
	</c:choose>

    
</head>
<body class="text-center">
<div class="container">
<h3>로그인</h3>
  <hr/>
<center>
	<form action="${contextPath }/member/login.do" method="post">
	    <div class="col-md-4 col-md-offset-3" >
	   		<input type="text" name="u_id" class="form-control" placeholder="아이디">
	    </div>
	    <p></p>
	    <br>
	    <div class="col-md-4 col-md-offset-3">
	    	<input type="password" name="u_pw" class="form-control" placeholder="비밀번호">
	    </div>
	    <div class="checkbox mb-3">
	    	<label>
	        	<input type="checkbox" value="remember-me"> 아이디 저장하기
	      	</label>
	      	<a href="${contextPath }/member/findForm.do" id="idFind">ID/PW 찾기</a>
	    </div>
	    <input value="로그인" class="btn btn-primary" type="submit"/><br><br>
	    <input type="button" value="회원가입" class="btn btn-primary" onClick="location.href='${contextPath}/member/joinForm.do'">   
	</form>
</center>
</div>
</body>
</html>
