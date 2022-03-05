package com.lms.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

import com.lms.model.exam.Quiz;
import com.lms.service.QuizService;




@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	
	@Autowired
    private QuizService quizService;

    //add quiz service
//    @PostMapping("/")
//    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
//    	System.out.println("Adding quiz");
//        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
//    }
    
	 @PostMapping("/")
	    public ResponseEntity<Map> add(@RequestBody Quiz quiz) {
	    	Map<String, Object> response = new HashMap<>();
	    	Quiz quiz1 = this.quizService.addQuiz(quiz);   	
	    	System.out.println("Adding quiz");
	    	if(quiz1 != null)
			{
				response.put("data", quiz1);
				response.put("status","ADDING QUIZ SUCCESSFULLY");			
			}
			else
			{
				response.put("status","FAIL");
				response.put("error","FAILED TO LOAD");
			}
			return	new ResponseEntity<>(response,HttpStatus.OK);	
		
	    } 
    
  
    //update quiz
//
//    @PutMapping("/")
//    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
//    	System.out.println("Updating quiz");
//        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
//    }
    

	    @PutMapping("/")
	    public ResponseEntity<Map> update(@RequestBody Quiz quiz) {
	    	Map<String, Object> response = new HashMap<>();
	    	Quiz quiz1 = this.quizService.updateQuiz(quiz); 
	    	System.out.println("Updating quiz");
	    	if(quiz1 != null)
			{
				response.put("data", quiz1);
				response.put("status","UPDATED QUIZ SUCCESSFULLY");			
			}
			else
			{
				response.put("status","FAIL");
				response.put("error","FAILED TO LOAD");
			}
			return	new ResponseEntity<>(response,HttpStatus.OK);	
		
	    } 

    //get quiz
//    @GetMapping("/")
//    public ResponseEntity<?> quizzes() {
//    	System.out.println("Getting quiz");
//        return ResponseEntity.ok(this.quizService.getQuizzes());
//    }

    @GetMapping("/")
    public ResponseEntity<Map> getQuizzes() {
    	Map<String, Object> response = new HashMap<>();
    	Set<Quiz> quizes = this.quizService.getQuizzes();   	
    	System.out.println("Getting quiz");
    	if(quizes != null)
		{
			response.put("data", quizes);
			response.put("status","GETTING CATEGORY SUCCESSFULLY");			
		}
		else
		{
			response.put("status","FAIL");
			response.put("error","FAILED TO LOAD");
		}
		return	new ResponseEntity<>(response,HttpStatus.OK);	
	
    } 

  //get single quiz
    @GetMapping("/{id}")
    public ResponseEntity<Map> quiz(@PathVariable("id") Long Id) {
    	Map<String, Object> response = new HashMap<>();
    	Quiz quiz = this.quizService.getQuiz(Id);   	
    	System.out.println("Getting quiz by id");
    	if(quiz != null)
		{
			response.put("data", quiz);
			response.put("status","GETTING QUIZ SUCCESSFULLY");			
		}
		else
		{
			response.put("status","FAIL");
			response.put("error","FAILED TO LOAD");
		}
		return	new ResponseEntity<>(response,HttpStatus.OK);	
	
    } 
 
 
//    //get single quiz
//    @GetMapping("/{id}")
//    public Quiz quiz(@PathVariable("id") Long Id) {
//    	System.out.println("Getting quiz by id");
//        return this.quizService.getQuiz(Id);
//    }

    //delete the quiz
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long Id) {
    	System.out.println("Deleted Successfully");
        this.quizService.deleteQuiz(Id);
    }

   
   
    
//    @GetMapping("/category/{id}")
//    public List<Quiz> getQuizzesOfCategory(@PathVariable("id") Long Id) {
//        Category category = new Category();
//        category.setCid(Id);
//        System.out.println("Getting Category");
//        return this.quizService.getQuizzesOfCategory(category);
//    }
//
//    //get active quizzes
//    @GetMapping("/active")
//    public List<Quiz> getActiveQuizzes() {
//    	System.out.println("getting active quizes");
//        return this.quizService.getActiveQuizzes();
//    }
//
//    //get active quizzes of category
//    @GetMapping("/category/active/{id}")
//    public List<Quiz> getActiveQuizzes(@PathVariable("id") Long Id) {
//        Category category = new Category();
//        category.setCid(Id);
//        System.out.println("getting active quizes of category");
//        return this.quizService.getActiveQuizzesOfCategory(category);
//    }
//
//	
//	

}
