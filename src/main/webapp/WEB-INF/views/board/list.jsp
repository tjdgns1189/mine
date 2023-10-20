<%@page import="edu.spring.ex02.domain.BoardVO"%>
<%@page import="edu.spring.ex02.pageutil.PageMaker"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
   border-style : solid;
   border-width : 1px;
   text-align : center;
}

ul {
    list-style-type : none;
}

li {
    display : inline-block;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js" 
integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous">
</script>
<title>게시판 메인 페이지</title>
</head>
<body>

    <h1>게시판 메인</h1>
 
    
    <a href="register"><input type="button" value="글 작성"></a>
 
    <hr>
    <table>
    	<thead>
    		<tr>
    			<th style="width : 60px">번호</th>
    			<th style="width : 700px">제목</th>
    			<th style="width : 120px">작성자</th>
    			<th style="width : 100px">작성일</th>
    			<th style="width : 60px">댓글수</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="vo" items="${list }"> <!-- 서블릿에서 넘어온 list데이터. 어트리뷰트로. -->
    			<tr>
    				<td>${vo.boardId }</td>
    				<td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page}">${vo.boardTitle }</a></td> <!--  사이트이동하는데 데이터보내면서-->
    				<td>${vo.memberId }</td>
    				<fmt:formatDate value="${vo.boardDateCreated }"
    				pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
    				<td>${vo.boardDateCreated }</td>
    				<td>${vo.replyCnt }
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    <ul>
    	<c:if test="${pageMaker.hasPrev }">
    		<li><a href="list?page=${pageMaker.startPageNo - 1 }">이전</a></li>
    	</c:if>
        <c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }"
        	var="num">
        	<li><a href="list?page=${num }">${num }</a></li>
        </c:forEach>
        <c:if test="${pageMaker.hasNext }">
    		<li><a href="list?page=${pageMaker.endPageNo + 1 }">다음</a></li>
    	</c:if>
    
    </ul>
    
    <!-- BoardController -> registerPOST()에서 보낸 데이터 저장 -->
    <input type="hidden" id="insertAlert" value="${insert_result }">
    
    <script type="text/javascript">
    	var result = ${'#insertAlert'}.val();
    	if(result == 'success'){
    		alert('새 글 작성 성공!!');
    	}
    </script>
    
    
</body>
</html>