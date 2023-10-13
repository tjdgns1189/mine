package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SampleController3 {
	private static final Logger logger =
			LoggerFactory.getLogger(SampleController3.class);
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute(name="username") String username) {
		// @ModerAttribute : ��û���� ������(username)�� view�� ����
		// name = "username" : model.addAttribute()�� Ű ��(username)�� �ǹ�
		return "param-test";
	} // end test3()
	
	@GetMapping("/test4")
	public String test4(@ModelAttribute(name="username") String username,
			@ModelAttribute(name="age") int age) {
		logger.info("");
		return "param-test";
	} // end test4()

}
