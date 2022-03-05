package com.lms.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.exam.Category;
import com.lms.model.exam.Question;
import com.lms.repo.CategoryRepository;
import com.lms.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	 @Autowired
	    private CategoryRepository categoryRepository;
	

	@Override
	public Category addCategory(Category category) {
		 return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		 return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		 return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long Id) {
		 return this.categoryRepository.findById(Id).get();
	}

	@Override
	public void deleteCategory(Long Id) {
		 Category category = new Category();
	        category.setId(Id);
	        this.categoryRepository.delete(category);
		
	}
	

}
