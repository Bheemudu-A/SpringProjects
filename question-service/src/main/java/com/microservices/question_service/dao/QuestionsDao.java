package com.microservices.question_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.question_service.model.Question;

@Repository
public interface QuestionsDao extends JpaRepository<Question, Integer>{

	List<Question> findByDifficultyLevel(String diffLevel);

	@Query(value = "select q.id from question q where q.difficulty_level=:difficultyLevel ORDER BY RANDOM() LIMIT :numQ", nativeQuery=true)
	List<Integer> findQuestionsByDifficulty(String difficultyLevel, int numQ);
	
	/*
	 * @Query(value=
	 * "select q.id from question q where q.difficulty_level=:difficultyLevel ORDER BY RANDOM() LIMIT : numQuestions"
	 * , nativeQuery=true) List<Integer>
	 * findQuestionsByEasy(@Param("difficultyLevel") String difficultyLevel, int
	 * numQuestions);
	 */
}
