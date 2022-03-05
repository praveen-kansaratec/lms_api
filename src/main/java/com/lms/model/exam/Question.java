package com.lms.model.exam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotEmpty
	@Column(length = 5000)
	private String content;

	private String image;

	@NotEmpty
	private String option1;
	
	@NotEmpty
	private String option2;
	
	@NotEmpty
	private String option3;
	
	@NotEmpty
	private String option4;

	private String answer;
	private Long User_Created;

	private Date date_created;

	private Date date_Modified;

	private Long User_Modified;

	@Transient
	private String givenAnswer;

	private Long quizId;
  
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Quiz quiz;

	public Question() {

	}

	

	public Long getQuizId() {
		return quizId;
	}



	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

//	public Quiz getQuiz() {
//		return quiz;
//	}
//
//
//
//	public void setQuiz(Quiz quiz) {
//		this.quiz = quiz;
//	}



	public Long getUser_Created() {
		return User_Created;
	}

	public void setUser_Created(Long user_Created) {
		User_Created = user_Created;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDate_Modified() {
		return date_Modified;
	}

	public void setDate_Modified(Date date_Modified) {
		this.date_Modified = date_Modified;
	}

	public Long getUser_Modified() {
		return User_Modified;
	}

	public void setUser_Modified(Long user_Modified) {
		User_Modified = user_Modified;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}



}
