package com.lms.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	//adding category
	@PostMapping("/")
	public ResponseEntity<Map> addCategory(@RequestBody Category category) {
		Map<String, Object> response = new HashMap<>();
		Category category1 = this.categoryService.addCategory(category);
		System.out.println("Added category successfully");
		if (category1 != null) {
			response.put("data", category1);
			response.put("status", "ADDED CATEGORY SUCCESSFULLY");
		} else {
			response.put("status", "FAIL");
			response.put("error", "CAN NOT ADD");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	//getting specific category by id
	@GetMapping("/{Id}")
	public ResponseEntity<Map> getCategory(@PathVariable("Id") Long Id) {
		Map<String, Object> response = new HashMap<>();
		Category category1 = this.categoryService.getCategory(Id);
		System.out.println("Observed category  successfully by getting it by specified id");
		if (category1 != null) {
			response.put("data", category1);
			response.put("status", "GETTING CATEGORY SUCCESSFULLY");
		} else {
			response.put("status", "FAIL");
			response.put("error", "FAILED TO LOAD");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	// get all categories
	@GetMapping("/")
	public ResponseEntity<?> getCategories() {
		System.out.println("Observed all category successfully");
		return ResponseEntity.ok(this.categoryService.getCategories());
	}

	//updating category
	@PutMapping("/")
	public ResponseEntity<Map> updateCategory(@RequestBody Category category) {
		Map<String, Object> response = new HashMap<>();
		Category category1 = this.categoryService.updateCategory(category);
		System.out.println("Observed category  successfully by getting it by specified id");
		if (category1 != null) {
			response.put("data", category1);
			response.put("status", "CATEGORY UPDATED SUCCESSFULLY");
		} else {
			response.put("status", "FAIL");
			response.put("error", "FAILED TO UPDATE");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	// delete category
	@DeleteMapping("/{Id}")
	public void delete(@PathVariable("Id") Long Id) {
		System.out.println("Deletion of specified one is Done successfully");
		this.categoryService.deleteCategory(Id);
	}

}
