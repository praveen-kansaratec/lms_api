package com.lms.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lms.model.exam.Question;

@Service
public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestionsByQuizId(Long quiz_id);

	public void deleteQuestion(Long Id);

	public Question get(Long Id);

}
