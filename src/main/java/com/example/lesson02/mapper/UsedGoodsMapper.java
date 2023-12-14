package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {
	
	// input: x (BO로부터 받는것)
	// output: (service한테 주는것) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	
}
