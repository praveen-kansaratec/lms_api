package com.lms.model.exam;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	private String title;
	
	@Column(length = 5000)
	private String description;
	
	private String maxMarks;
	
	private String numberOfQuestions;
    private Long User_Created;
	

	private Date date_created;
	

	private Date date_Modified;
	
	private Long User_Modified;
	
	private boolean active = false;
	//add... 
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	
	
	public Quiz() {
		
	}
	
	//getter setter
	public Long getqId() {
		return Id;
	}
	public void setqId(Long qId) {
		this.Id = Id;
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
	public String getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	 public Set<Question> getQuestions() {
	        return questions;
	    }

	    public void setQuestions(Set<Question> questions) {
	        this.questions = questions;
	    }

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

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
	
	
	
	
	
	
}
