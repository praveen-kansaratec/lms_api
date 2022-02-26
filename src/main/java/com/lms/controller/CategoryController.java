package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.exam.Category;
import com.lms.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

    //add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.addCategory(category);
        System.out.println("Added category successfully");
        return ResponseEntity.ok(category1);
    }

    //get category
    @GetMapping("/{Id}")
    public Category getCategory(@PathVariable("Id") Long Id) {
    	 System.out.println("Observed category  successfully by getting it by specified id");
        return this.categoryService.getCategory(Id);
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
    	 System.out.println("Observed all category successfully");
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
    	 System.out.println("Updation Done successfully");
        return this.categoryService.updateCategory(category);
    }

    //delete category
    @DeleteMapping("/{Id}")
    public void deleteCategory(@PathVariable("Id") Long Id) {
    	 System.out.println("Deletion of specified one is Done successfully");
        this.categoryService.deleteCategory(Id);
    }
	
	

}
