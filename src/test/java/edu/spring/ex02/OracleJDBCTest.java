package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;
// ctrl shift o �ѹ濡 ����Ʈ
// �ͽ����η� ���� fi�� �Ѵܾ�� �νĹ���
@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //** �ؿ� ���ֵ�. �� xml�����ֵ�
@WebAppConfiguration 
public class OracleJDBCTest {
	private static final Logger logger =
			LoggerFactory.getLogger(OracleJDBCTest.class);
	
	private static final String URL =
			"jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	@Test // �׽�Ʈ��ɺ���
	public void testOracleConnect() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());// OracleDriver() �ؿ��� ����Ʈ ����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("oracle ���� ����");
		} catch (SQLException e) {
			logger.error("oracle ���� ���� : " + e.getMessage());
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
	
}
