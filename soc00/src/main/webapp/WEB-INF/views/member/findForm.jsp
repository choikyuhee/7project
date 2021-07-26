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
<title>아이디/비번찾기</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
      h3{
      	text-align:center;
      }
      .container{
      	padding-top:50px;
      	padding-bottom:50px;
      }
</style>
	<c:choose>
		<c:when test="${result == 'notFound' }">
	
    <script type="text/javascript">
	    	window.onload=function(){
				alert("없는 회원입니다");
			}
	</script>
	</c:when>
	</c:choose>

</head>

<body>
<div class="container">
	<h3>아이디/비밀번호 찾기 &nbsp;&nbsp;</h3>
	<hr/>
	<br>	
	<form action="${contextPath }/member/idFind.do" method="post">
   	<div class="row">
   		<div class="col-md-4 offset-md-4" style="text-align:center;">
   			<h5>아이디 찾기</h5>
   			<br>
    		<input type="text" name="u_name" id="name" placeholder="예)홍길동" style="width:300px">
            	
        </div>
    </div>
    <br>
    <div class="col-md-4 offset-md-4" style="text-align:center;">
    	<button class="btn btn-default" id="idFind" type="submit" >확인</button>
    </div>
    </form>
    <br>
    <form>
    <div class="row">
    	<div class="col-md-4 offset-md-4" style="text-align:center;">
    		<h5>비밀번호 찾기</h5>
    		<br>
    		<input type="text" placeholder="ID" style="width:300px"/>
    		<br>
    		<br>
    		<input type="text" placeholder="이메일 주소 입력" style="width:300px">
    		
  	 	</div>
    </div>
    <br>
    <div class="col-md-4 offset-md-4" style="text-align:center;">
    	<button class="btn btn-sm btn-default" type="submit" onclick="">전송</button>
    </div>
    </form>
</div>
</body>
</html>