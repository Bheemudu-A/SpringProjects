package com.src.demo.SpringSession.SpringJDBCConnection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.demo.SpringSession.SpringJDBCConnection.model.Student;
import com.src.demo.SpringSession.SpringJDBCConnection.repository.SpringJDBCRepository;

@Service
public class SpringJDBCService {
	
	private SpringJDBCRepository repo;
	
	public SpringJDBCRepository getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(SpringJDBCRepository repo) {
		this.repo = repo;
	}
	
	public void addDBlayer(Student s) {
		System.out.println("Added DB Layer");		
		repo.save(s);
	}

	public java.util.List<Student> getStudentsList() {
		return repo.findAll();
	}
}
