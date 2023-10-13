package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleJSONController {
	private static final Logger logger =
			LoggerFactory.getLogger(SampleJSONController.class);
	
	//자바때 JSON쉽게 표현
	@GetMapping("/json1")
	public String json1() {
		logger.info("json1() 호출");
		return "sample1"; // jsp 호출
	} // end json1()
	
	@GetMapping("/json2")
	@ResponseBody // jsp를 돌려주는 형태에서 json(데이터)만 돌려주는 형태로 바꿔줌. 댓글에사용
	public String json2() {
		logger.info("json2() 호출");
		return "Hello, Spring"; // jsp가 아닌 json을 보내는것이라 Hello, Spring.jsp없어도 에러안뜸.
	} // end json2()
	
	@GetMapping("/json3")
	@ResponseBody
	public ProductVO json3() {
		logger.info("json3() 호출");
		return new ProductVO("야구공", 10000);
	} // end json3()
	
} // end SampleJSONController
