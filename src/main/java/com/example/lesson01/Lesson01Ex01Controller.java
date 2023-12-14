package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 공통인 주소를 클래스위에 어노테이션으로 해놓을 수있음., 메소드 위에 붙은 패스보다 먼저 읽혀진다. 
@Controller // spring bean(객체)으로 등록하겠다는 의미 -> 알아서 new를 시켜줌 
public class Lesson01Ex01Controller {

	// 1. String을 브라우저에 출력해보기
	// url: http://localhost:80/lesson01/ex01/1
	@RequestMapping("/1") //이주소로 들어왔을때 아래 메소드를 수행하겠다라는 주소
	@ResponseBody // 리턴되는 값을 responsebody에 넣어 보낸다 -> 최종적으로 HTML로 변환되어 출력됨
	public String ex01_1() {
		return "<h2>예제1번</h2> 문자열을 ResponseBody로 보내는 예제";
	}
	
	// 2. Map 리턴 => JSON String으로 출력 (제이슨은 모양만 키벨류지 스트링이다)
	// url: http://localhost:80/lesson01/ex01/2
	@RequestMapping("/2")
	// @ResponseBody위치는 아래처럼 쓸 수도있지만 예전방식이다. 
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("사과", 4);
		map.put("포도", 32);
		map.put("멜론", 50);
		map.put("귤", 10);
		
		// map을 리턴하면 json으로 나타난다.
		// 그 이유는 프로젝트 세팅할때 web projectstarter에 jackson라이브러리가 포함되어있기 때문이다. 
		return map;
	} 
}
