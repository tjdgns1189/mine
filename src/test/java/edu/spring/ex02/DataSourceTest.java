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
// ctrl shift o �ѹ濡 ����Ʈ
// �ͽ����η� ���� fi�� �Ѵܾ�� �νĹ���
@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //** �ؿ� ���ֵ�. �� xml�����ֵ�
@WebAppConfiguration 
public class DataSourceTest {
	private static final Logger logger =
			LoggerFactory.getLogger(DataSourceTest.class);
	
	// Spring Framework�� �����ϴ� DataSource ��ü�� ���Թ���
	// - root-context.xml���� bean���� ���õ� DataSource ��ü�� ���Թ���
	
	@Autowired // ����(�󿡼� ����� ������)
	private DataSource ds; // �ؿ�������Ʈ
	
	@Test // ������ ����Ʈ
	public void testDataSource() { 
		Connection conn = null;
		
		try {
			conn = ds.getConnection(); // ���⼭ try catch
			logger.info("DataSource ���� ����");
		} catch (SQLException e) {
			logger.error("DataSource ���� ���� : " + e.getMessage());
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
