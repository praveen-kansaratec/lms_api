package com.lms.controller;

import java.util.HashMap;
import java.util.List;
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


import com.lms.model.exam.Question;
import com.lms.service.QuestionService;





@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	
	 @Autowired
	    private QuestionService service;

	

	    @PostMapping("/")
	    public ResponseEntity<Map> add(@RequestBody Question question) {
		  Map<String, Object> response = new HashMap<>();
		  Question question1 = this.service.addQuestion(question);
	        System.out.println("Added question successfully");
	        if(question1 != null)
			{
				response.put("data", question1);
				response.put("status","ADDED QUESTION SUCCESSFULLY");			
			}
			else
			{
				response.put("status","FAIL");
				response.put("error","CAN NOT ADD QUESTION");
			}
			return	new ResponseEntity<>(response,HttpStatus.OK);	
		
	    } 
	    
	    
//	    //add question
//	    @PostMapping("/add/")
//	    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
//	    	System.out.println("Addition in question Done successfully");
//	        return ResponseEntity.ok(this.service.updateQuestion(question));
//	    }
	  //add question
	    @PostMapping("/add/")
	    public ResponseEntity<Map> addQuestion(@RequestBody Question question) {
	    	Map<String, Object> response = new HashMap<>();
	    	Question question1 = this.service.addQuestion(question);
	    	System.out.println("Addition in question Done successfully");
	    	if(question1 != null)
			{
				response.put("data", question1);
				response.put("status","ADDED QUESTION SUCCESSFULLY");			
			}
			else
			{
				response.put("status","FAIL");
				response.put("error","CAN NOT ADD");
			}
			return	new ResponseEntity<>(response,HttpStatus.OK);	
		
	    } 
	    
	    //update the question
	    @PutMapping("/")
	    public ResponseEntity<Map> update(@RequestBody Question question) {
	    	Map<String, Object> response = new HashMap<>();
	    	Question question1 = this.service.updateQuestion(question);
	    	System.out.println("Updation in question Done successfully");	      
	    	if(question1 != null)
			{
				response.put("data", question1);
				response.put("status","UPDATION IN QUESTION DONE SUCCESSFULLY");			
			}
			else
			{
				response.put("status","FAIL");
				response.put("error","CAN NOT ADD");
			}
			return	new ResponseEntity<>(response,HttpStatus.OK);	
		
	    } 
	    
	    
//	    @GetMapping("/quiz/{id}")
//	    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("id") Long quiz_id) {
//	       
//	     
//	        Set<Question> questionsOfQuiz = this.service.getQuestionsByQuizId(quiz_id);
//	    
//	        System.out.println("Getting questions by specified id from quiz");
//	        return ResponseEntity.ok(questionsOfQuiz);
//
//	    }

	    @GetMapping("/quiz/{id}")
	    public ResponseEntity<Map> getQuestionsOfQuiz(@PathVariable("id") Long quiz_id) {
	    	Map<String, Object> response = new HashMap<>();
	    	//Question question1 = this.service.updateQuestion(question);
	    	  Set<Question> questionsOfQuiz = this.service.getQuestionsByQuizId(quiz_id);
	    	//System.out.println("Updation in question Done successfully");	      
	    	  System.out.println("Getting questions by specified id from quiz");
	    	  if(questionsOfQuiz != null)
			{
				response.put("data", questionsOfQuiz);
				response.put("status","GETTING SUCCESSFULLY");			
			}
			else
			{
				response.put("status","FAIL");
				response.put("error","CAN NOT LOAD");
			}
			return	new ResponseEntity<>(response,HttpStatus.OK);	
		
	    }  

	    
	    
	    
	    
//	    //update the question
//	    @PutMapping("/")
//	    public ResponseEntity<Question> update(@RequestBody Question question) {
//	    	System.out.println("Updation in question Done successfully");
//	        return ResponseEntity.ok(this.service.updateQuestion(question));
//	    }

	    //get all question of any quiz
//	    @GetMapping("/quiz/{id}")
//	    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("id") Long quiz_id) {
//	       
//	     
//	        Set<Question> questionsOfQuiz = this.service.getQuestionsByQuizId(quiz_id);
//	    
//	        System.out.println("Getting questions by specified id from quiz");
//	        return ResponseEntity.ok(questionsOfQuiz);
//
//	    }


//

	    //delete question
	    @DeleteMapping("/{Id}")
	    public void delete(@PathVariable("Id") Long Id) {
	    	System.out.println("Deleting question by id");
	        this.service.deleteQuestion(Id);
	    }
	    
	
	    //eval quiz
	    @PostMapping("/eval-quiz")
	    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
	        System.out.println(questions);
	        double marksGot = 0;
	        int correctAnswers = 0;
	        int attempted = 0;
	        for (Question q : questions) {
	            //single questions
	            Question question = this.service.get(q.getId());
	            if (question.getAnswer().equals(q.getGivenAnswer())) {
	                //correct
	                correctAnswers++;

	             //   double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMax_marks()) / questions.size();
	                //       this.questions[0].quiz.maxMarks / this.questions.length;
	             //   marksGot += marksSingle;

	            }

	            if (q.getGivenAnswer() != null) {
	                attempted++;
	            }

	        }
	        ;

	        Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted);
	        System.out.println("Evaluation done!!");
	        return ResponseEntity.ok(map);

	    }
	
	

}
