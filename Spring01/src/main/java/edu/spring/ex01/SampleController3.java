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
		// @ModerAttribute : 요청받은 데이터(username)을 view에 전송
		// name = "username" : model.addAttribute()의 키 값(username)을 의미
		return "param-test";
	} // end test3()
	
	@GetMapping("/test4")
	public String test4(@ModelAttribute(name="username") String username,
			@ModelAttribute(name="age") int age) {
		logger.info("");
		return "param-test";
	} // end test4()

}
