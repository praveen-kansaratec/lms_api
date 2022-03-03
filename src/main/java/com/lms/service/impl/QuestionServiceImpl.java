package com.lms.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.exam.Question;
import com.lms.model.exam.Quiz;
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
	public Set<Question> getQuestions() {
		 return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long Id) {
		  return this.questionRepository.findById(Id).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		 return this.questionRepository.findByQuiz(quiz);
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



  

}
