package com.microservices.quiz_service.dao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.quiz_service.model.QuestionWrapper;
import com.microservices.quiz_service.model.Services;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	

	@GetMapping("/question/generate")
	public ResponseEntity<List<Integer>> getQuestionsofEasy(@RequestParam String categoryName, @RequestParam Integer questions);
	
	@PostMapping("/question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(@RequestBody List<Integer> quesId);
	
	@PostMapping("/question/score")
	public ResponseEntity<Integer> getScore(@RequestBody List<Services> ans);
	
}
