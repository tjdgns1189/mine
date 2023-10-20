package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;
// ctrl shift o �ѹ濡 ����Ʈ
// �ͽ����η� ���� fi�� �Ѵܾ�� �νĹ���
@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //** �ؿ� ���ֵ�. �� xml�����ֵ�
@WebAppConfiguration 
public class SqlSessionFactoryTest {
	private static final Logger logger =
			LoggerFactory.getLogger(SqlSessionFactoryTest.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testSqlSessionFactory() {
		SqlSession session = sessionFactory.openSession();
		if(session != null) {
			logger.info("SqlSession ���� ����");
		} else {
			logger.info("SqlSession ���� ����");
		}
	}
	
} // end DataSourceTest
