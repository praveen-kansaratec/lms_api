package com.lms.service;

import java.util.Set;

import com.lms.model.exam.Category;



public interface CategoryService {
	
	 public Category addCategory(Category category);

	    public Category updateCategory(Category category);

	    public Set<Category> getCategories();

	    public Category getCategory(Long Id);

	    public void deleteCategory(Long Id);
	
	

}
