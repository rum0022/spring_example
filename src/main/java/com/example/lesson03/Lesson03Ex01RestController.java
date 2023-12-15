package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBo reviewBo;
	// url: http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01() {
		return reviewBo.getReview(); //responsebody ->json  단건으로 !
	}
}
