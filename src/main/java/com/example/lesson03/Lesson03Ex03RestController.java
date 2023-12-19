package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;

@RestController
public class Lesson03Ex03RestController {

	@Autowired
	private ReviewBo reviewBo;
	
	// url:http://localhost/lesson03/ex03?id=44&review=도미노피자는역시맛있어~~
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
		
		int rowCount = reviewBo.updateReviewById(id, review);
			   return "변경완료:" + rowCount;
	}
}
