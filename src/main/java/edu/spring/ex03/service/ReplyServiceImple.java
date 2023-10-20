package edu.spring.ex03.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.BoardDAO;
import edu.spring.ex03.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	// @Transactional
	// - �� ���� �����ͺ��̽��� ������ ���� ��,
	// ���� ������ ������ �� ���¿���, �Ʒ� ������ ������ �߻��ϸ�
	// ���� ������ rollback �Ǿ�� �Ѵ�.
	// �̷� ����� �������ִ� Spring annotation
	// - root-context.xml���� ����
	
	@Autowired
	private BoardDAO boardDAO; 

	@Transactional(value = "transactionManager")
	@Override
	public int create(ReplyVO vo) throws Exception{
		// ���(test_reply)�� �����Ͱ� �����ϸ�
		// �Խ���(test_board)�� ��� ����(reply_cnt)�� ����Ǿ�� ��
		// test_reply ���̺� insert�� �����ϸ�
		// test_board ���̺� update�� �����Ѵ�.
		logger.info("create() ȣ�� : vo = " + vo.toString());
		int resultInsert = replyDAO.insert(vo);
		logger.info(resultInsert + " �� ��� �Է� ����");
		int result = boardDAO.updateReplyCnt(1, vo.getBoardId());
		logger.info(result + " �� ���� ����");
		return 1;
	}

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("read() ȣ�� : boardId = " + boardId);
		return replyDAO.select(boardId);
	}

	@Override
	public int update(int replyId, String replyContent) {
		logger.info("update() ȣ��");
		logger.info("replyId = " + replyId + ", replyContent = " + replyContent);
		return replyDAO.update(replyId, replyContent);
	}

	@Transactional(value = "transactionManager")
	@Override
	public int delete(int replyId, int boardId) throws Exception{
		logger.info("delete() ȣ�� : replyId = " + replyId);
		int resultDelete = replyDAO.delete(replyId);
		logger.info(resultDelete + " �� ���� ����");
		int result = boardDAO.updateReplyCnt(-1, boardId);
		logger.info(result + "�� ���� ����");
		return 1;
	}

}






