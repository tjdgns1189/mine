package edu.spring.ex01;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController2 {
	private static final Logger logger =
			LoggerFactory.getLogger(SampleController2.class);
	
	@GetMapping("/test1")
	public String test1(Model model, String username) {
		// username : request.getParameter("username");
		logger.info("test1() ȣ�� : username = " + username);
		
		model.addAttribute("username", username);
		return "param-test";
	}
	
	@GetMapping("/test2")
	public String test2(Model model, String username, int age) {
		// username : request.getParameter("username");
		logger.info("test2() ȣ��");
		logger.info("username = " + username);
		logger.info("age = " + age);
		
		// Model : view�� �����͸� �����ϱ� ���� ��ü
		model.addAttribute("username", username);
		model.addAttribute("age", age);		
		return "param-test";
		
		//http://localhost:8080/ex01/test2?username=������&age=30
	}
}
