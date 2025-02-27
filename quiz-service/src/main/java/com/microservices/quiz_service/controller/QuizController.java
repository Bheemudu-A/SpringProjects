package com.microservices.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.quiz_service.model.QuestionWrapper;
import com.microservices.quiz_service.model.QuizDTO;
import com.microservices.quiz_service.model.Services;
import com.microservices.quiz_service.service.QuizService;

@RestController()
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> createQuiz(@RequestBody QuizDTO quixDto) {
		
		try {
			return new ResponseEntity<>(service.createQuiz(quixDto.getCategory(), quixDto.getNumQ(), quixDto.getTitle()), HttpStatus.ACCEPTED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable int id){	
		return new ResponseEntity<>(service.getQuestionById(id), HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<?> getRightAnswersByCount(@PathVariable int id, @RequestBody List<Services> serv){		
		return new ResponseEntity<>(service.getRightAnswerByCount(id, serv), HttpStatus.CREATED);
		
	}

}
