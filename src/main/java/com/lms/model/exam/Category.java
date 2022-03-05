package com.lms.model.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	//,cascade = CascadeType.ALL
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<>();
	
	
//private Long User_Created;
//	
//
//	private Date date_created;
//	
//
//
//	private Date date_Modified;
//	
//	private Long User_Modified;
	
	
	
	//default constructor
	public Category() {
		
	}

	//parameterized constructor
	

	
	//getter setter
	
//Long user_Created, Date date_created,Date date_Modified, Long user_Modified
	public Category(String title, String description, Set<Quiz> quizzes) {
		super();
		this.title = title;
		this.description = description;
		this.quizzes = quizzes;
//		User_Created = user_Created;
//		this.date_created = date_created;
//		this.date_Modified = date_Modified;
//		User_Modified = user_Modified;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

//	public Long getUser_Created() {
//		return User_Created;
//	}
//
//	public void setUser_Created(Long user_Created) {
//		User_Created = user_Created;
//	}
//
//	public Date getDate_created() {
//		return date_created;
//	}
//
//	public void setDate_created(Date date_created) {
//		this.date_created = date_created;
//	}
//
//	public Date getDate_Modified() {
//		return date_Modified;
//	}
//
//	public void setDate_Modified(Date date_Modified) {
//		this.date_Modified = date_Modified;
//	}
//
//	public Long getUser_Modified() {
//		return User_Modified;
//	}
//
//	public void setUser_Modified(Long user_Modified) {
//		User_Modified = user_Modified;
//	}
//	
//	
	
	
	
}
