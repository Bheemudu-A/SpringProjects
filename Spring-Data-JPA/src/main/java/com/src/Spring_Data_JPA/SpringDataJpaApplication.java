package com.src.Spring_Data_JPA;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.src.Spring_Data_JPA.Repository.StudentRepo;
import com.src.Spring_Data_JPA.model.Student;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
	
	Student s1 = context.getBean(Student.class);
	Student s2 = context.getBean(Student.class);
	Student s3 = context.getBean(Student.class);
	
	StudentRepo repo=context.getBean(StudentRepo.class);

	
	s1.setMarks(99);
	s1.setName("Bheem");
	s1.setRollNum(2);
	
	s2.setMarks(100);
	s2.setName("Koushika");
	s2.setRollNum(1);
	
	repo.save(s1);
	repo.save(s2);
	
	System.out.println("fetching all DB data : "+repo.findAll());
	
	System.out.println("Fetching data by primary key : "+repo.findById(s2.getRollNum()));	
	
	Optional<Student> data = repo.findById(103);// Optinal method is used to handle null pointer, it is introduced in java 8
	
	System.out.println("Data : "+data);
	
	//if we want to fetch data by otherthan primary key we need to write method StudentRepo, as there is no default impelementation
		 System.out.println("Fetching Data Based on Name : "+ repo.findByName(s1.getName()));
			
		System.out.println("Fetching Data by marks greater than 90" + repo.findByMarksGreaterThan(90));	
		
		/*
		 * Note: to fetch data we need to use method as --findBy+your requirment
		 */
		
		//to create and update we use same method repo.save(obj);
		
		s2.setMarks(100);
		s2.setName("Koushika");
		s2.setRollNum(6);//changing rullnum to 6
		
		repo.save(s2);
		
		//deleting s1 data
		repo.delete(s1);
		
	}
 
	
	
}
