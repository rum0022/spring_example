package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody 그냥 컨트롤러만쓸때랑 혼합될때랑 사용법이 완전다르다!! 중요!
public class Lesson01Ex01RestController {

	// URL: http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController를 사용해 String을 리턴해본다.";
	}
	
	// URL: http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;
	}
	
	// URL: http://localhost/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); //일반 java bean(객체)
		data.setId(10);
		data.setName("아름");
		
		return data; //일반 bean 객체도 JSON으로 변환된다.
	}
	
	// URL: http://localhost/lesson01/ex01/6  -> 에러상황변경가능함
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("아름");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // OK-200 , INTERNAL_SERVER_ERROR - 500에러
	}
}
