package com.microservices.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.question_service.dao.QuestionsDao;
import com.microservices.question_service.model.Question;
import com.microservices.question_service.model.QuestionWrapper;
import com.microservices.question_service.model.Services;

@Service
public class QuestionsService {

	@Autowired
	QuestionsDao dao;
	
	public List<Question> getAllQuestions() {
		
		return dao.findAll();
	}

	public List<Question> getDataByDifficultyLevel(String diffLevel) {
		return dao.findByDifficultyLevel(diffLevel);
	}

	public void addQuestion(Question question) {
		dao.save(question);
		System.out.println("Successfully saved");
	}

	public ResponseEntity<List<Integer>> getQuestionsofEasy(String difficultyLevel, Integer numQuestions) {		
		List<Integer> quesCount = dao.findQuestionsByDifficulty(difficultyLevel, numQuestions);
		return new ResponseEntity<>(quesCount, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(List<Integer> quesId){
		List<Question> question = new ArrayList<>();
		List<QuestionWrapper> quesWrapper = new ArrayList<>();
		
				for(Integer id : quesId) {
					question.add(dao.findById(id).get());
				}
				
				for(Question ques : question) {
					QuestionWrapper wrapper = new QuestionWrapper();
					wrapper.setQuestionTitle(ques.getQuestionTitle());
					wrapper.setOption1(ques.getOption1());
					wrapper.setOption2(ques.getOption2());
					wrapper.setOption3(ques.getOption3());
					wrapper.setOption4(ques.getOption4());
					wrapper.setId(ques.getId());
					quesWrapper.add(wrapper);
				}
		
		return new ResponseEntity<>(quesWrapper, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<Integer> getScore(List<Services> ans) {
		
		Integer RightAnsCount =0 ;
		for(Services service: ans) {
			Question question = dao.findById(service.getId()).get();
			System.out.println("service : "+service.getResponse()+" question : "+question.getRightAnswer());
			if(service.getResponse().equals(question.getRightAnswer())) {
				RightAnsCount++;
			}
		}
		
		return new ResponseEntity<>(RightAnsCount, HttpStatus.ACCEPTED);
	}

}
