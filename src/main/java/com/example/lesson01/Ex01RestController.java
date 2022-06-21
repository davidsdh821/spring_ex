package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring bean
@RequestMapping("/lesson01/ex01") //아래부분의 것을 생략할 수 있다.
@RestController //컨트롤러는 자동으로 연동을 해주지만 일반적인 자바bean은 직접 연결해야한다.
public class Ex01RestController {
	//http://localhost:8080/lesson01/ex01/3
	//한 프로젝트 내에서는 컨트롤러의 명이나 requestmapping의 주소가 겹치면 안된다.
	@RequestMapping("/3") //위에의 매핑과 이어붙일 수 있다.
	public String ex01_3() {
		return "@RestController를 사용하여 String을 리턴한다.";
	}
	//http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
	
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map;
		
	}
	//http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();
		data.setId(1);
		data.setName("홍길동");
		
		return data; //jackson 라이브러리로 인해 자동 정렬됨
		
	}
	
	//http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("사람");
		
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	
}
