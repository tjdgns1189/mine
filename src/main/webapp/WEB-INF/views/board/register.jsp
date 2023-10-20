<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js" 
integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous">
</script>
<title>글 작성 페이지</title>
</head>
<body>
<!-- jsp자체실행 404에러. 다막아둠. index로만 -->
<!-- 디비 기준이 아닌 쿼리기준으로 데이터갯수적기. 3개. -->
	<h2>글 작성 페이지</h2>
	<form action="register" method="POST">
		<div>
			<p>제목 : </p>
			<input type="text" name="boardTitle" placeholder="제목 입력" requied>
		</div>
		<div>
			<p>작성자 : </p>
			<input type="text" name="memberId" value="박진성" readonly="readonly">
		</div>
		<div>
			<p>내용 : </p>
			<textarea rows="20" cols="120" name="boardContent" placeholder="내용 입력"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>