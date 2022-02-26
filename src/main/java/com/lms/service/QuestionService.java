package com.lms.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lms.model.exam.Question;
import com.lms.model.exam.Quiz;


@Service
public interface QuestionService {
	
	public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long Id);

    public Question get(Long Id);
	
	

}
