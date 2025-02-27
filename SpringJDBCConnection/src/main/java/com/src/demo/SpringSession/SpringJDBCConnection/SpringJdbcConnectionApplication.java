package com.src.demo.SpringSession.SpringJDBCConnection;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.src.demo.SpringSession.SpringJDBCConnection.model.Student;
import com.src.demo.SpringSession.SpringJDBCConnection.service.SpringJDBCService;

@SpringBootApplication
public class SpringJdbcConnectionApplication {

	public static void main(String[] args) {
		ApplicationContext cont = SpringApplication.run(SpringJdbcConnectionApplication.class, args);
		System.out.println("welcome to SpringBoot");
		
		Student s = cont.getBean(Student.class);
		s.setMarks(99);
		s.setName("Bheemudu");
		s.setRollNum(10043314);
		
		SpringJDBCService service = cont.getBean(SpringJDBCService.class);
		service.addDBlayer(s);
		
		List<Student> std = service.getStudentsList();
		
		for(Student student : std) {
			System.out.println(student.toString());
		}
		
	//	System.out.println("std : "+std);
	}

}
