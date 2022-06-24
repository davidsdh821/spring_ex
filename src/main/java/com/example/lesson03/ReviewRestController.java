package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;


@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost/lesson03/ex01?id=2
	//http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
//			@RequestParam(value="id") int id //필수파라미터
//			@RequestParam(value = "id", required = true) int id //필수파라미터 2(false일경우 null허용) 방식의 차이
//			@RequestParam("id") int id //필수파라미터 3
//			@RequestParam(value="id", required=false ) Integer id //비필수파라미터, 데이터를 받는 모든 곳에 integer로 바꾸어야한다
			@RequestParam(value = "id", defaultValue = "1") int id  //defaultValue는 아무 값도 없을때 작동한다, 단 모든 값에""를 붙여주어야한다
			)  {
		System.out.println("###### id:" + id);
		return reviewBO.getReview(id);
	}
}
