<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctx = request.getContextPath();	//콘텍스트명 얻어오기.
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<title>뉴스 수정</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
  
</head>
<body>
<div class="container">
<h3>뉴스 수정</h3>
<hr/>
<form id="frm" action="${contextPath }/board/newsModi.do" method="post" >
<table align="center">
        <tr>
            <td>제목</td>
            <td><input type="text" id="title" name="title" value="${article.title }" style="width:850px"/></td>
        </tr>
        <tr>
        	<td>아이디</td>
        	<td><input class="col-md-2 form-control" type="text" name="u_id" value="${member.u_id }" readonly></td>
			<td><input type="hidden" name="no" value="${article.no }"/></td>
        	
        </tr>
        <tr>
        	<td>카테고리</td>
        	<td>
        	<select class="col-md-2 form-control" id="category" name="category">
  				<option>국내기사</option>
  				<option>해외기사</option>
  				<option>기타</option>

			</select>
        	</td>
        </tr>
     	<tr>
            <td>내용</td>
            <td>
             	<textarea class="summernote" name="content">${article.content }</textarea>
            </td>
        </tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글쓰기"  />
				<input type="button" value="취소"/>
			</td>
		</tr>
</table>
</form>
</div>

<script>
$('.summernote').summernote({
	  width: 850,
	  height: 250,
	  lang: "ko-KR"
	});
</script>
</body>
</html>