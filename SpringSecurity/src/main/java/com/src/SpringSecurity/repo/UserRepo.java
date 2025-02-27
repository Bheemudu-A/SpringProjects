package com.src.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.src.SpringSecurity.model.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUsername(String username);
}
