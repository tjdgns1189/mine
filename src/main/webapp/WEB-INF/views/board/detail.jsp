<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js" 
integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous">
</script>
<title>${vo.boardTitle }</title>
</head>
<body>
	<h2>글 보기</h2>
	<div>
		<p>글 번호 : ${vo.boardId }</p>
	</div>
	<div>
		<p>제목 : </p>
		<p>${vo.boardTitle }</p>
	</div>
	<div>
		<p>작성자 : ${vo.memberId }</p>
		<p>작성일 : ${vo.boardDateCreated }</p>
	</div>
	<div>
		<textarea rows="20" cols="120" readonly>${vo.boardContent }</textarea>
	</div>
	<!-- 글목록누를때 page데이터 추가 -->
	<a href="list?page=${page }"><input type="button" value="글 목록"></a>
	

 		<a href="update?boardId=${vo.boardId }&page=${page }"><input type="button" value="글 수정"></a>
		<form action="delete" method="POST">
			<input type="hidden" id="boardId" name="boardId" value="${vo.boardId }"> <!-- vo.boardId가져가기위함으로 id붙임 -->
			<input type="submit" value="글 삭제">
		</form>   	

    
 

	
	
</body>
</html>