package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP 컨트롤러
@Controller //@ResponseBody가 있으면 안된다!! (@RestController도 안됨)
public class Lesson01Ex02Controller {

	// url:localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") //Request path주소
	public String ex02() {
		// return 되는 String은 jsp의 경로이다(@ResponseBody이 없을때!)
	    // return "/WEB-INF/jsp/lesson01/ex03.jsp"; <- 404뜸
		// application.properties에 프로픽스해놨으므로 생략하고 써야함
		return "lesson01/ex03"; //response view의 경로
	}
}
