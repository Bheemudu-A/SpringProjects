package com.microservices.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.quiz_service.model.Quiz;


public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
