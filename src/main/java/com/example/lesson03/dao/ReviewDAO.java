package com.example.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	public Review selectReview(int id); //()즉 파라미터 안에 무언가 들어있으면 xml에 파라미터타입도 넣어야한다
	//타입이 여러개가 있을 때는 어노테이션을 써야한다.
}
