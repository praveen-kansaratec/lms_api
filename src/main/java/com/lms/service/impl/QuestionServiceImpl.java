package com.lms.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.exam.Question;
import com.lms.repo.QuestionRepository;
import com.lms.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}


	@Override
	public void deleteQuestion(Long Id) {
		Question question = new Question();
		question.setId(Id);
		this.questionRepository.delete(question);

	}

	@Override
	public Question get(Long Id) {
		return this.questionRepository.getOne(Id);
	}

	@Override
	public Set<Question> getQuestionsByQuizId(Long quiz_id) {
		return this.questionRepository.findByQuizId(quiz_id);
	}

}
