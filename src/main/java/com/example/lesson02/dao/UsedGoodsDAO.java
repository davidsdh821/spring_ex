package com.example.lesson02.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	
	public List<UsedGoods> selectUsedGoodsList();
	//db와 가장 가까이 있는 부분이기 때문에 sql문과 비슷하게 이름짓는다.
	//이곳에서 db의 데이터를 직접 가져온다(sql쿼리문을 사용한다)
}
