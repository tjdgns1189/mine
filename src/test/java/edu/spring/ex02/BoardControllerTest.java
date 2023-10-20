package edu.spring.ex02;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import edu.spring.ex02.domain.BoardVO;
import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class) 

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
@WebAppConfiguration 
public class BoardControllerTest {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardControllerTest.class);
	
	@Autowired
	private WebApplicationContext wac; // �� ���ø����̼� ��ü
	
	// MVC ������ ���� �׽�Ʈ�ϴ� mock-up ��ü
	private MockMvc mock;
	
	@Before
	// JUint �׽�Ʈ�� �����ϱ� ���� �ʱ�ȭ �۾��� �����ϴ� �޼ҵ�
	public void beforeTest() {
		logger.info("beforeTest() ȣ��");
		// ��Ʈ�ѷ� �޼ҵ忡�� ��û�� ���� �� �ִ� mockup ��ü ����
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test() {
		testList();
	}

	private void testList() {
		logger.info("testList() ȣ��");
		
		MultiValueMap<String, String> params =
				new LinkedMultiValueMap<String, String>();
		params.add("page", "1");
		params.add("numsPerPage", "3");
		
		RequestBuilder requestBuilder = get("/board/list").params(params);
		
		
		
		try {
			mock.perform(requestBuilder);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

} // end DataSourceTest
