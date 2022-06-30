package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;
import com.example.lesson04.model.User;

@Service
public class UserBO {
	
	@Autowired
	UserDAO userDAO;
	
	
	public void addUserAsField(String name, String yyyymmdd, String email, String introduce) {
		
		userDAO.insertUserAsField(name, yyyymmdd, email, introduce);
	}
	
	public User getLastUser() {
		return userDAO.selectLastUser();
	}
	
}
