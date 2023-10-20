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
// ctrl shift o 한방에 임폴트
// 익스프로러 에러 fi를 한단어로 인식버그
@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //** 밑에 모든애들. 중 xml가진애들
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
			logger.info("SqlSession 생성 성공");
		} else {
			logger.info("SqlSession 생성 실패");
		}
	}
	
} // end DataSourceTest
