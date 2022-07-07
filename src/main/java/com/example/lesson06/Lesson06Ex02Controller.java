package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Ex02Controller {
	@Autowired
	private UserBO userBO;
	
	
	// 회원가입 화면
	//http://localhost/lesson06/sign_up_view
	@RequestMapping("/lesson06/sign_up_view")
	public String singUpView() {
		
		return "lesson06/signUpView";

	}
	//이름 중복 확인 - ajax가 호출한 api
	//get, post 둘다 가능 ,duplication은 중복이라는 뜻(자주쓴다)
	@GetMapping("/lesson06/is_duplication")
	@ResponseBody //ajax호출의 응답은 반드시 reposnebody => json String으로 리턴
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		//boolean인 이유 true false로만 판단할 수 있기 때문이다
		//model은 jsp한테만 쓰기 때문에 앞으로 model의 역할은 ajax가 처리한다
		
		
		//db select
		//과제, 테이블(new_user)
		boolean isDuplication = userBO.existUserByName(name); //중복이면 true
		
		//
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", true); //중복이면 true
		
		
		return result;
	}
	
	
}
