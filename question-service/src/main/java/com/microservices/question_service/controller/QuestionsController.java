package com.microservices.question_service.controller;

import java.util.List;

import org.springframework.core.env.Environment;
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

import com.microservices.question_service.model.Question;
import com.microservices.question_service.model.QuestionWrapper;
import com.microservices.question_service.model.Services;
import com.microservices.question_service.service.QuestionsService;

@RestController
@RequestMapping("/question")
public class QuestionsController {

	@Autowired
	QuestionsService queService;
	
	@Autowired
	Environment environment;

	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionsofEasy(@RequestParam String categoryName, @RequestParam Integer questions){
		System.out.println(environment.getProperty("local.server.port"));
		return queService.getQuestionsofEasy(categoryName, questions);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(@RequestBody List<Integer> quesId){
		return queService.getQuestionsByID(quesId);
		
	}
	
	@PostMapping("score")
	public ResponseEntity<Integer> getScore(@RequestBody List<Services> ans){
		return queService.getScore(ans);
		
	}
}
