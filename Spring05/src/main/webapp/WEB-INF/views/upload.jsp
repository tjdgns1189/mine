<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 폼</h1>
	<h2>단일 파일 업로드</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="userid">
		<input type="text" name="email">
		<input id="test" type="file" name="file"><br>
		<input type="submit" value="업로드">
	</form>
	<!-- vo로 스트링들어가는데 파일도 경로로 스트링 -->
	
	<h2>다중 파일 업로드</h2>
	<form action="upload2" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple"><br> <!-- 멀티플=여러개보냄. 받는쪽도 여러개 -->
		<input type="submit" value="업로드">
	</form>
</body>
</html>