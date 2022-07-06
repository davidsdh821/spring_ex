package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	//유저를 추가할 수 있는 view 화면
	@Autowired
	private UserBO UserBO; //public으로 만들었기 때문에 다른 패키지에서 사용이 가능하다
	
	//http://localhost/lesson06/add_user_view
	@RequestMapping("/add_user_view")
	public String addUserView() {
		
		
		return "lesson06/addUserView";
	}
	
	
	//유저 추가
	@ResponseBody
	@PostMapping("/add_user")
	public String addUser(@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required = false) String email,
			@RequestParam(value="introduce", required = false) String introduce) {
		
		//insert db
		UserBO.addUserAsField(name, yyyymmdd, email, introduce);
		
		
		return "입력 성공";
	}
	
}
