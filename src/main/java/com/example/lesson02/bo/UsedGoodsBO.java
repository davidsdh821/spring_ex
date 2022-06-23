package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO; //private는 관례적으로 붙는 것
	
	public List<UsedGoods> getUsedGoodsList() {
		
		return usedGoodsDAO.selectUsedGoodsList(); //usedGoodsDAO의 selectUsedGoodsList로 보내는 것
	}
}
