package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //restcontroller아님
public class Ex02Controller {
	
	//controller -> viewresolver 클래스 -> 경로 찾아서 jsp -> html
	//http://localhost/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String ex02_1() {
		
		//responseBody가 아닌 상태로 String을 리턴하면 
		//리턴된 String 이름의 jsp view를 찾고 화면이 구성된다.
		// return 
		
		return "lesson01/ex02"; //prefix, suffisx 제외 jsp view 경로와 이름
	}
	
}
