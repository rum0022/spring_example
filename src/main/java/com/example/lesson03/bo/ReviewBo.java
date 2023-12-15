package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBo {

	@Autowired
	private ReviewMapper reviewMapper;
	//input : x  output : Review
	public Review getReview() {
		return reviewMapper.selectReview();
	}
}
