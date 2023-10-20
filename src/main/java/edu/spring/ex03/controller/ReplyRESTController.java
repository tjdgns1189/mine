package edu.spring.ex03.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

// * RESTful url�� �ǹ�
// /replies (POST) : ��� �߰�(insert)
// /replies/all/���� (GET) : �ش� �� ��ȣ(boardId)�� ��� ��� �˻�(select)
// /replies/���� (PUT) : �ش� ��� ��ȣ(replyId)�� ������ ����(update)
// /replies/���� (DELETE) : �ش� ��� ��ȣ(replyId)�� ����� ����(delete)

@RestController
@RequestMapping(value="/replies")
public class ReplyRESTController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping // POST : ��� �Է�
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO vo) {
		// @RequestBody
		// - Ŭ���̾�Ʈ���� ���۹��� json �����͸�
		//   �ڹ� ��ü�� ��ȯ���ִ� annotation
		logger.info("createReply() ȣ�� : vo = " + vo.toString());
		
		// ResponseEntity<T> : Rest ��Ŀ��� �����͸� ������ �� ���̴� ��ü
		// - ������ HttStatus�� ����
		// - <T> : �������� �ϴ� ������ Ÿ��
		int result = 0;
		try {
			result = replyService.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("/all/{boardId}") // GET : ��� ����(all)
	public ResponseEntity<List<ReplyVO>> readReplies(
			@PathVariable("boardId") int boardId) {
		// @PathVariable("boardId") : /all/{boardId} ���� ������ ������ ����
		logger.info("readReplies() ȣ�� : boardId = " + boardId);
		
		List<ReplyVO> list = replyService.read(boardId);
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		
	}
	
	@PutMapping("/{replyId}") // PUT : ��� ����
	public ResponseEntity<Integer> updateReply(
			@PathVariable("replyId") int replyId,
			@RequestBody String replyContent
			){
		int result = replyService.update(replyId, replyContent);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/{replyId}")
	public ResponseEntity<Integer> deleteReply(
			@PathVariable("replyId") int replyId,
			@RequestBody int boardId){
		logger.info("replyId = " + replyId);
		
		int result = 0;
		try {
			result = replyService.delete(replyId, boardId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
}











