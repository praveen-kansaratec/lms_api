package com.lms.model;

public class Topic {

	private int id;
	private String name;
	
	public Topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Topic() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
