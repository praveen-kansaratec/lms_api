package com.lms.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.exam.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuizId(Long quiz_id);

}
