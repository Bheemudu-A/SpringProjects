package com.src.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.src.SpringSecurity.model.User;
import com.src.SpringSecurity.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public User saveUserDetails(User user) {	
		user.setPassword(encoder.encode(user.getPassword()));
		
		System.out.println("encoded password : "+user.getPassword());
		return repo.save(user);
	}

}
