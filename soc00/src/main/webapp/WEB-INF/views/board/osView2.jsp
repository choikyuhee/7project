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
	<title>게시글조회</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet"> 
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
  
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="${contextPath}/resources/summernote/summernote-lite.js"></script>
  <script src="${contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${contextPath}/resources/summernote/summernote-lite.css">
  <!--  -->
  
  <style>
  	#a1{
			text-align:right;
	}
  </style>
</head>
<body>
<div class="container">
<h3>조회</h3>
<hr/>
<table align="center">
        <tr>
            <td>제목</td>
            <td><input type="text" id="title" name="title" value="${article.title}"style="width:850px"/></td>
        </tr>
        <tr>
        	<td>아이디</td>
        	<td><input class="col-md-2 form-control" type="text" name="u_id" value="${member.u_id }" readonly></td>

        	
        </tr>
        <tr>
        	<td>카테고리</td>
        	<td>
	  			<select class="col-md-2 form-control" id="category" name="category" value="${article.category }">
	  				<option>EPL</option>
	  				<option>세리에</option>
	  				<option>라리가</option>
	  				<option>분데스리가</option>
	  				<option>리그앙</option>
	  				<option>기타리그</option>
				</select>
        	</td>
        </tr>
        <tr>
        	<td>작성일</td>
        	<td><fmt:formatDate value="${article.regdate }" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea class="summernote" readonly>${article.content }</textarea>
            </td>
        </tr>
     
</table>
		<p id="a1">
			<c:if test ="${member.u_id == article.u_id || member.u_admin == 1 }">
				<a id="a1" class="btn btn-primary" href="${contextPath }/board/osModiView.do?no=${article.no}">글수정</a>
				<a id="a1" class="btn btn-primary" href="${contextPath }/board/osDelete.do?no=${article.no}">글삭제</a>
			</c:if>
			<a id="a2" class="btn btn-primary" href="${contextPath }/board/osSoccer.do">글목록</a>
		</p>
</div>
</body>
<script>
$('.summernote').summernote({
	  width: 850,
	  height: 250,
	  lang: "ko-KR"
	});
</script>
</html>
