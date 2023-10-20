package edu.spring.ex03.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.ex03.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReplyVO vo) {
		logger.info("insert() ȣ�� : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReplyVO> select(int boardId) {
		logger.info("select() ȣ�� : boardId = " + boardId);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_board_id", boardId);
		
	}

	@Override
	public int update(int replyId, String replyContent) {
		logger.info("update() ȣ��");
		logger.info("replyId = " + replyId + ", replyContent = " + replyContent);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("replyId", replyId);
		args.put("replyContent", replyContent);
		return sqlSession.update(NAMESPACE + ".update", args);
	}

	@Override
	public int delete(int replyId) {
		logger.info("delete() ȣ�� : replyId = " + replyId);
		return sqlSession.delete(NAMESPACE + ".delete", replyId);
	}

}





