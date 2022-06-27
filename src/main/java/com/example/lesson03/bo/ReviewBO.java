package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) { //int는 id 값을 꼭 줘야할때(null이 있기 때문), integer는 id에 null도 허용을 한다
		
		return reviewDAO.selectReview(id);
	}
	
	public int addReview(Review review) {
		return reviewDAO.insertReview(review);
		
	}
	public int addReviewAsField( 
			String storeName, String menu, String userName, double point, String review) {
		return reviewDAO.insertReviewAsField("도미노피자", "콤비네이션R", "홍길동", 5.0, "맛있다");
	}
	
	
	public int updateReviewById(int id, String review) {
		
		return reviewDAO.updateReviewById(id, review);
	}
}
