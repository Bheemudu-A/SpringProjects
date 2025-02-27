package com.src.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.src.SpringSecurity.model.User;
import com.src.SpringSecurity.service.UserService;

@RestController()
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public User getUserRegisteration(@RequestBody User user) {
		return service.saveUserDetails(user);
	}

}
