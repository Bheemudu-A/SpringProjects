package com.microservices.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.microservices.quiz_service.dao.QuizDao;
import com.microservices.quiz_service.dao.QuizInterface;
import com.microservices.quiz_service.model.Question;
import com.microservices.quiz_service.model.QuestionWrapper;
import com.microservices.quiz_service.model.Quiz;
import com.microservices.quiz_service.model.Services;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	
	//@Autowired
	//ApplicationContext app;
	
	
public Object createQuiz(String difficultyLevel, int numQ, String title) {		
		List<Integer>  questions = quizInterface.getQuestionsofEasy(difficultyLevel, numQ).getBody();	
		
//	String[] beans = app.getBeanDefinitionNames();
		
		Quiz quiz = new Quiz();
		quiz.setId(numQ);
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		
		return "Success";
	}
	

	
	public  ResponseEntity<List<QuestionWrapper>> getQuestionById(int id) {
		
		Optional<Quiz>  quiz = quizDao.findById(id);
		List<Integer> question = quiz.get().getQuestionIds();
		 ResponseEntity<List<QuestionWrapper>> quesWrapper = quizInterface.getQuestionsByID(question);
		
		return quesWrapper;
	}

	public ResponseEntity<Integer> getRightAnswerByCount(int id, List<Services> serv) {
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Integer> question = quiz.get().getQuestionIds();
		ResponseEntity<Integer> rightAnsCount = quizInterface.getScore(serv);	
		return rightAnsCount;
	}

}
