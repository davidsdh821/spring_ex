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
	//http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() { //한번에 전송
		Review reivew = new Review();
		reivew.setStoreName("배달삼겹");
		reivew.setMenu("삼겹혼밥세트");
		reivew.setUserName("신동현");
		reivew.setPoint(4.5);
		reivew.setReview("혼자 먹기 적당하네요.");
		
		int row = reviewBO.addReview(reivew); //insert 된 수를 리턴받는다
		
		return row > 0? "행 입력 성공했습니다." : "실패했습니다.";
	
	}
	//이 방식은 순서가 똑같아야 한다.
	//http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() { //파라미터로 보내기
		
		int row = reviewBO.addReviewAsField("도미노피자", "콤비네이션R", "홍길동", 5.0, "맛있다"); //insert 된 수를 리턴받는다
		
		return row > 0? "행 입력 성공했습니다." : "실패했습니다.";
	}
	
	//업데이트
	//http://localhost/lesson03/ex03?id=20&review=도미노피자는 역시 맛있어
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
		 
		int row  = reviewBO.updateReviewById(id, review);
		return "변경완료: " + row;
	}
	
	

	
	
	
	
	
}
