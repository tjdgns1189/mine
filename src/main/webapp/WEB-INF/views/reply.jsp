<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js" 
integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>


	
	<input type="hidden" id="boardId" name="boardId" value="1">

	<div style="text-align: center;">
		<input type="text" id="memberId" >
		<input type="text" id="replyContent">
		<button id="btnAdd">작성</button>
	</div>

	
	<hr>
	<div style="text-align: center;">
		<div id="replies"></div>
	</div>
	
	<div>
		<br><br><br><br><br><br><br><br><br><br>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			getAllReplies();
			
			$('#btnAdd').click(function(){
				var boardId = $('#boardId').val(); // 게시판 번호 데이터
				var memberId = $('#memberId').val(); // 작성자 데이터
				var replyContent = $('#replyContent').val(); // 댓글 내용
				var obj = {
						'boardId' : boardId, 
						'memberId' : memberId,
						'replyContent' : replyContent
				};
				console.log(obj);
				
				// $.ajax로 송수신
				$.ajax({
					type : 'POST', 
					url : 'replies',
					headers : {
						'Content-Type' : 'application/json'
					},
					data : JSON.stringify(obj), // JSON으로 변환
					success : function(result){
						console.log(result);
						if(result == 1) {
							alert('댓글 입력 성공');
							getAllReplies();
						}
					}
				}); // end ajax()
			}); // end btnAdd.click()
			
			// 게시판 댓글 전체 가져오기
			function getAllReplies() {
				var boardId = $('#boardId').val();
				
				var url = 'replies/all/' + boardId;
				$.getJSON(
					url, 
					function(data) {
						// data : 서버에서 전송받은 list 데이터가 저장되어 있음.
						// getJSON()에서 json 데이터는
						// javascript object로 자동 parsing됨.
						console.log(data);
					
						var memberId = $('#memberId').val();
						var list =''; // 댓글 데이터를 HTML에 표현할 문자열 변수	
						
						// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
						$(data).each(function(){
							// this : 컬렉션의 각 인덱스 데이터를 의미
							console.log(this);
							
							var replyDateCreated = new Date(this.replyDateCreated);
							var disabled = 'disabled';
							var readonly = 'readonly';
							
							if(memberId == this.memberId) {
								disabled = '';
								readonly = '';
							}
							
							list += '<div class="reply_item">'
								+ '<pre>'
								+ '<input type="hidden" id="replyId" value="' + this.replyId +'">'
								+ this.memberId
								+ '&nbsp;&nbsp;' // 공백
								+ '<input type="text" id="replyContent" value="' + this.replyContent + '">'
								+ '&nbsp;&nbsp;' // 공백
								+ replyDateCreated
								+ '&nbsp;&nbsp;' // 공백
								+ '<button class="btn_update" >수정</button>'
								+ '<button class="btn_delete" >삭제</button>'
								+ '</pre>'
								+ '</div>';
						}); // end each()

						$('#replies').html(list);
					}
				); // end getJSON()
			} // end getAllReplies()
			
			// 수정 버튼을 클릭하면 선택된 댓글 수정
			$('#replies').on('click', '.reply_item .btn_update', function(){
				console.log(this);
				
				// 선택된 댓글의 replyId, replyContent 값을 저장
				// prevAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
				var replyId = $(this).prevAll('#replyId').val();
				var replyContent = $(this).prevAll('#replyContent').val();
				console.log("선택된 댓글 번호 : " + replyId + ", 댓글 내용 : " + replyContent);
				
				// ajax 요청
				$.ajax({
					type : 'PUT', 
					url : 'replies/' + replyId, 
					headers : {
						'Content-Type' : 'application/json'
					},
					data : replyContent,
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('댓글 수정 성공!');
							getAllReplies();
						}
					}
				}); // end ajax()
			}); // end replies.on()
			
			
			// 삭제 버튼을 클릭하면 선택된 댓글 삭제
			$('#replies').on('click', '.reply_item .btn_delete', function(){
				console.log(this);
			
				var boardId = $('#boardId').val();
				var replyId = $(this).prevAll('#replyId').val();
				console.log("선택된 댓글 번호 : " + replyId);
				
				// ajax 요청
				$.ajax({
					type : 'DELETE', 
					url : 'replies/' + replyId, 
					headers : {
						'Content-Type' : 'application/json'
					},
					data : boardId,
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('댓글 삭제 성공!');
							getAllReplies();
						}
					}
				}); // end ajax()
			}); // end replies.on()
			
		}); // end document
	</script>
	
</body>
</html>






















