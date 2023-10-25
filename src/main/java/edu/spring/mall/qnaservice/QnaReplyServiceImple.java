package edu.spring.mall.qnaservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.mall.qnaservice.QnaReplyServiceImple;
import edu.spring.mall.domain.QnaBoardVO;
import edu.spring.mall.domain.QnaReplyVO;
import edu.spring.mall.persistence.QnaReplyDAO;
import edu.spring.mall.qnapageutil.PageCriteria;

@Service
public class QnaReplyServiceImple implements QnaReplyService {
	private static final Logger logger = 
			LoggerFactory.getLogger(QnaReplyServiceImple.class);

	@Autowired
	private QnaReplyDAO qnaReplyDAO;

	@Override
	public int create(QnaReplyVO vo) throws Exception {
		logger.info("create() ȣ�� : vo = " + vo.toString());
		int resultInsert = qnaReplyDAO.insert(vo);
		logger.info(resultInsert + " �� ��� �Է� ����");
		return 1;
	}

	@Override
	public List<QnaReplyVO> read(int qnaBoardId) {
		logger.info("read() ȣ�� : qnaBoardId = " + qnaBoardId);
		return qnaReplyDAO.select(qnaBoardId);
	}

	@Override
	public int update(int qnaReplyId, String qnaReplyContent) {
		logger.info("update() ȣ��");
		logger.info("qnaReplyId = " + qnaReplyId + ", qnaReplyContent = " + qnaReplyContent);
		return qnaReplyDAO.update(qnaReplyId, qnaReplyContent);
	}

	@Override
	public int delete(int qnaReplyId) throws Exception {
		logger.info("delete() ȣ�� : qnaReplyId = " + qnaReplyId);
		return qnaReplyDAO.delete(qnaReplyId);
	}
	
	
	
	
}