package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// POJO : Plain Old Java Object
@Controller
// servlet-context.xml ���Ͽ���
// component-scanning�� ������� ������ִ� ������̼�
// @Component ������̼��� ����ص� ��
public class SampleController1 {
	// ������ �����ӿ�ũ���� �α׸� ����ϱ� ���� ��ü
	private static final Logger logger =
			LoggerFactory.getLogger(SampleController1.class); // .class�� Ŭ������ ������ �ش�.
	
	@RequestMapping(value="/sample1", method=RequestMethod.GET)
	// @RequestMapping : ��Ʈ�ѷ��� URL ���ΰ�
	// �޼ҵ�(GET/POST/PUT/DELETE)�� ����
	// value = URL ���
	// method = ��û ��� ����(GET, POST, PUT, DELETE)
	// short cut ��� : @GetMapping, @PostMapping, ....
	public String sample1() {
		logger.info("sample1() ȣ��");
		return "sample1"; // jsp ��� �� �̸�
		// WEB-INF/views/sample1.jsp�� ã�ư�(servlet-context.xml �� �����Ǿ� ����)
		// * ��Ʈ�ѷ� �޼ҵ� return ���� �ǹ�
		// ViewResolver���� ���� view�� �����ϵ���(ã����) ��û
		// return Ÿ���� void�� ���� URL ������ ���ؼ� view�� ã��
		
		
// java jsp �ȵ���. ����. ��η� ���Ͷ�.
		
	} // end sample1()
	
	@RequestMapping(value="/sample2")
	public void sample2() {
		logger.info("sample2() ȣ��");
	}
}// end sampleController1
