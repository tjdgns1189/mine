package edu.spring.mall.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.mall.domain.QnaBoardVO;
import edu.spring.mall.qnapageutil.PageCriteria;

@Repository
public class QnaBoardDAOImple implements QnaBoardDAO{
	
	private static final Logger logger = 
			LoggerFactory.getLogger(QnaBoardDAOImple.class);
	
	private static final String NAMESPACE =
			"edu.spring.mall.QnaBoardMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(QnaBoardVO vo) {
		logger.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<QnaBoardVO> select() {
		logger.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public QnaBoardVO select(int qnaBoardId) {
		logger.info("select() ȣ�� : qnaBoardId = " + qnaBoardId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_qna_board_id", qnaBoardId);
	}

	@Override
	public List<QnaBoardVO> select(PageCriteria criteria) {
		logger.info("select() ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public int update(QnaBoardVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int qnaBoardId) {
		logger.info("delete() ȣ�� : qnaBoardId = " + qnaBoardId);
		return sqlSession.delete(NAMESPACE + ".delete", qnaBoardId);
	}

	@Override
	public List<QnaBoardVO> select(String memberId) {
		logger.info("select() ȣ�� : memberId = " + memberId);
		return sqlSession.selectList(NAMESPACE + ".select_by_memberid", "%" + memberId + "%");
	}

	@Override
	public List<QnaBoardVO> selectByTitleOrContent(String keyword) {
		logger.info("selectByTitleOrContent() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", "%" + keyword + "%");
	}

}
