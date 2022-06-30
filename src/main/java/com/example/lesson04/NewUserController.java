package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	@Autowired
	UserBO userBO;
	
	//405 에러: 메소드가 불일치
	//http://localhost/lesson04/sign_up_view
	@RequestMapping(path = "/sign_up_view", method = RequestMethod.GET)
	public String signUpView() {
		// /WEB-INF/jsp/  .jsp 가운데의 공백을 채워야 함
		return "lesson04/addUserView"; //view의 경로를 찾아 jsp를 연다.
 		
	}
	
	//http://localhost/lesson04/add_user
//	@RequestMapping(path = "/add_user", method = RuquestMethod.POST)
	@PostMapping(path = "/add_user") //post만 받는 방식
	
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email",required = false) String email, 
			@RequestParam(value = "introduce", required = false) String introduce ) {
			
		//db insert
			userBO.addUserAsField(name, yyyymmdd, email, introduce);
			
		//response
		
		return "lesson04/afterAddUser";
		
	}
	
	//http://localhost/lesson04/last_user_view 
	//@RequestMapping도 가능하다
	@GetMapping("/last_user_view ") //get으로만 들어올 수 있다
	public String lastUserView(Model model) {
		//가장 최근에 가입한 사람 한명 정보 가져오기 -> select로 가져온다는 것
		User NewUser = userBO.getLastUser();
		
		
		//결과 jsp view에 결과 객체값을 model에 담아 넘긴다.
		model.addAttribute("result",  NewUser); //이름 ""은 마음대로 지으면 된다
		model.addAttribute("title", "회원정보");
		
		//response
		return "lesson04/lastUserView";//앞에 / 붙이지 말기
		
		
		
		
	}
	
	
}
