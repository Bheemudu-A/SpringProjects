package com.src.SpringSecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.src.SpringSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>(Arrays.asList(
			new Student(1, "bheem", "java"),
			new Student(2, "koushika", "python"))
			);
	
	
	@GetMapping("/students")
	public List<Student> getAllListOfStudents(){
		System.out.println("In controller");
		return students;
	}
	
	
	@PostMapping("/students")
	public void addStudent(@RequestBody Student std) {	
		students.add(std);
	}
	
	
	@GetMapping("/csrf_token")
	public CsrfToken getCsrfToken(HttpServletRequest req) {	
		return (CsrfToken) req.getAttribute("_csrf");
	}
			

}
