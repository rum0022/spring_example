package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBo reviewBo;
	// url: http://localhost/lesson03/ex01
	// url: http://localhost/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// @RequestParam(value = "id") int id //필수파라미터
			// @RequestParam(value = "id", required = true) int id // 필수파라미터
			// @RequestParam(value = "id", required = false) Integer id) { //비필수 파라미터
		//if (id == null) {
		//	id = 1;
		//}
				// @RequestParam(value = "id", defaultValue = "1") int id // 비필수  + 디폴트값 1
				   @RequestParam("id") int id) {   // 필수 파라미터
		return reviewBo.getReview(id); //responsebody ->json  단건으로 !
	}
}
