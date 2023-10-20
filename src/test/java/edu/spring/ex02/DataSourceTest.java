package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

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
public class DataSourceTest {
	private static final Logger logger =
			LoggerFactory.getLogger(DataSourceTest.class);
	
	// Spring Framework가 관리하는 DataSource 객체를 주입받음
	// - root-context.xml에서 bean으로 선택된 DataSource 객체를 주입받음
	
	@Autowired // 주입(빈에서 만들어 놓은것)
	private DataSource ds; // 밑에것임폴트
	
	@Test // 위에거 임폴트
	public void testDataSource() { 
		Connection conn = null;
		
		try {
			conn = ds.getConnection(); // 여기서 try catch
			logger.info("DataSource 연결 성공");
		} catch (SQLException e) {
			logger.error("DataSource 연결 실패 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
} // end DataSourceTest
