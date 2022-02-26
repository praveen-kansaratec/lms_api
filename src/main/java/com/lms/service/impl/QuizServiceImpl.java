package com.lms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.exam.Category;
import com.lms.model.exam.Quiz;
import com.lms.repo.QuizRepository;
import com.lms.service.QuizService;


@Service
@Transactional
public class QuizServiceImpl implements QuizService{

	 @Autowired
	    private QuizRepository quizRepository;
	
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		 return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		  return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		  return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		 return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		 this.quizRepository.deleteById(quizId);
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		return this.quizRepository.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		 return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		return this.quizRepository.findByCategoryAndActive(c, true);
	}

}
