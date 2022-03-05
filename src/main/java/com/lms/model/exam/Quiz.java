package com.lms.model.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@NotEmpty
	private String title;

	@NotEmpty
	@Column(length = 5000)
	private String description;

	@NotEmpty
	private String max_marks;

	@NotEmpty
	private String number_of_questions;

	private boolean active = false;
	// add..
//,, cascade = { CascadeType.ALL }
	//, cascade = { CascadeType.MERGE }
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	
//	@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = { CascadeType.ALL } )
//	@JsonIgnore
//	private Set<Question> questions = new HashSet<>(); 
	
	public Quiz() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMax_marks() {
		return max_marks;
	}

	public void setMax_marks(String max_marks) {
		this.max_marks = max_marks;
	}

	public String getNumber_of_questions() {
		return number_of_questions;
	}

	public void setNumber_of_questions(String number_of_questions) {
		this.number_of_questions = number_of_questions;
	}

	public boolean isActive() {
		return active;
	}

//	public Set<Question> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(Set<Question> questions) {
//		this.questions = questions;
//	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
