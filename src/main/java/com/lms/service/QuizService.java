package com.lms.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.lms.model.exam.Category;
import com.lms.model.exam.Quiz;


@Service
public interface QuizService {

	
	 public Quiz addQuiz(Quiz quiz);

	    public Quiz updateQuiz(Quiz quiz);

	   

//	    public Quiz getQuiz(Long quizId);
//	    public void deleteQuiz(Long quizId);
	    
	    
	    public Quiz getQuiz(Long quizId);
	    public void deleteQuiz(Long quizId);

	   public Set<Quiz> getQuizzes();
	    

//	    public List<Quiz> getQuizzesOfCategory(Category category);
//
//	    public List<Quiz> getActiveQuizzes();
//
//	    public List<Quiz> getActiveQuizzesOfCategory(Category c);
//	
//	
}
