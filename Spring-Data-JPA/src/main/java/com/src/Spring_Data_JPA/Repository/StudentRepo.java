package com.src.Spring_Data_JPA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.src.Spring_Data_JPA.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	@Query("select s from Student s where s.name=?1")//query to fetch data by name, 1 is used to fetch data for 1st input of name
	List<Student> findByName(String name);
	
	List<Student> findByMarksGreaterThan(int marks);

}