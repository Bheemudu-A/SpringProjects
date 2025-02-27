package com.src.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {

	@GetMapping("/hello")
	public String greet(HttpServletRequest request) {	
		return "Welcome to Spring Security : "+request.getSession().getId();
	}
	
	@GetMapping("/about")
	public String about(HttpServletRequest request) {
		return "How about you : "+request.getSession().getId();
	}
	
}
