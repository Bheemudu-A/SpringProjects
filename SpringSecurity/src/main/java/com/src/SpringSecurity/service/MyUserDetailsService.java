package com.src.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.src.SpringSecurity.model.User;
import com.src.SpringSecurity.model.UserPrincipal;
import com.src.SpringSecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("Invalid User");
			throw new UsernameNotFoundException("No user found as : "+user);
		}
		
		return new UserPrincipal(user);
	}

}
