package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// input:id output:Review
	public Review selectReview(int id); 
	
	//input: Review      output: x or 성공한 행의 개수를 int형으로 받아올 수 있음. 
	public int insertReview(Review review);
	// 하나의 맵이 된것 => @param
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
}
