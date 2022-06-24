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
	
}
