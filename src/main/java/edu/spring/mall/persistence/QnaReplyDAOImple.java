package edu.spring.mall.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.mall.domain.QnaReplyVO;

@Repository
public class QnaReplyDAOImple implements QnaReplyDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(QnaReplyDAOImple.class);

	private static final String NAMESPACE =
			"edu.spring.mall.QnaReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(QnaReplyVO vo) {
		logger.info("insert() ȣ�� : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<QnaReplyVO> select(int qnaBoardId) {
		logger.info("select() ȣ�� : qnaBoardId = " + qnaBoardId);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_qna_board_id", qnaBoardId);
	}

	@Override
	public int update(int qnaReplyId, String qnaReplyContent) {
		logger.info("update() ȣ��");
		logger.info("qnaReplyId = " + qnaReplyId + ", qnaReplyContent = " + qnaReplyContent);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("qnaReplyId", qnaReplyId);
		args.put("qnaReplyContent", qnaReplyContent);
		return sqlSession.update(NAMESPACE + ".update", args);
	}

	@Override
	public int delete(int qnaReplyId) {
		logger.info("delete() ȣ�� : qnaReplyId = " + qnaReplyId);
		return sqlSession.delete(NAMESPACE + ".delete", qnaReplyId);
	}

}
