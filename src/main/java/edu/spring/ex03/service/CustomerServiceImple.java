package edu.spring.ex03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImple implements CustomerService{
	private static final Logger logger = 
			LoggerFactory.getLogger(CustomerServiceImple.class);

	@Override
	public int createCustomer() throws Exception {
		logger.info("�� ���� ����");
		return 1;
	}

	@Override
	public int deleteCustomer() {
		logger.info("�� ���� ����");
		return 1;
	}

	@Override
	public int updateCustomer() throws Exception {
		logger.info("�� ���� ����");
		return 1;
	}

}
