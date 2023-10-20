<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.boardTitle }</title>
</head>
<body>
	<h2>글 수정 페이지</h2>
	<form action="update" method="POST">
	    <input type="hidden" name="page" value="${page }">
		<div>      <!-- div하는이유? 디자인하는사람들이 요소마다 나누더라 -->
			<p>글 번호 : ${vo.boardId }</p>
			<!--  <input type="text" name="boardId" value="${vo.boardId }" readonly> -->
			<input type="hidden" name="boardId" value="${vo.boardId }"> <!-- 폼에서 보내야하긴한데 안보이게 만듬 -->
		</div>
		<div>
			<p>제목 : </p>
			<input type="text" name="boardTitle" value="${vo.boardTitle }">
		</div>
		<div>
			<p>작성자 : ${vo.memberId }</p>
			<p>작성일 : ${vo.boardDateCreated }</p>
		</div>
		<div>
			<textarea rows="20" cols="120" name="boardContent">${vo.boardContent }</textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>