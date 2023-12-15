package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean으로 등록
public class UsedGoodsBO {
	
	@Autowired // Dependency Injection(DI) : 의존성 주입  -> 쉽게말해 Spring bean을 가져와서 사용하겠다는것
	private UsedGoodsMapper usedGoodsMapper;  // Spring bean을 가져온다 (new한게 아닌)
	
	// input:x (컨트롤러한테 받아온다)
	// output: (Repository한테 받은 것을) List<UsedGoods> (컨트롤러한테 준다)
	
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
	
}
