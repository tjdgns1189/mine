package edu.spring.mall.qnaservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.mall.domain.QnaBoardVO;
import edu.spring.mall.persistence.QnaBoardDAO;
import edu.spring.mall.qnapageutil.PageCriteria;

@Service
public class QnaBoardServiceImple implements QnaBoardService {
	private static final Logger logger =
			LoggerFactory.getLogger(QnaBoardServiceImple.class);
	
	@Autowired
	private QnaBoardDAO dao;
	
	@Override
	public int create(QnaBoardVO vo) {
		logger.info("create() ȣ�� : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<QnaBoardVO> read(PageCriteria criteria) {
		logger.info("read() ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public QnaBoardVO read(int qnaBoardId) {
		logger.info("read() ȣ�� : qnaBoardId = " + qnaBoardId);
		return dao.select(qnaBoardId);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() ȣ��");
		return dao.getTotalCounts();
	}

	@Override
	public int update(QnaBoardVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(int qnaBoardId) {
		logger.info("delete() ȣ�� : qnaBoardId = " + qnaBoardId);
		return dao.delete(qnaBoardId);
	}

}
