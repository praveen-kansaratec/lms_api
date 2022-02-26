package com.lms.controller;

import java.util.List;

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
import com.lms.model.exam.Quiz;
import com.lms.service.QuizService;




@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	
	@Autowired
    private QuizService quizService;

    //add quiz service
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
    	System.out.println("Adding quiz");
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz) {
    	System.out.println("Updating quiz");
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
    	System.out.println("Getting quiz");
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping("/{id}")
    public Quiz quiz(@PathVariable("id") Long id) {
    	System.out.println("Getting quiz by id");
        return this.quizService.getQuiz(id);
    }

    //delete the quiz
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
    	System.out.println("Deleted Successfully");
        this.quizService.deleteQuiz(id);
    }

    @GetMapping("/category/{id}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("id") Long id) {
        Category category = new Category();
        category.setCid(id);
        System.out.println("Getting Category");
        return this.quizService.getQuizzesOfCategory(category);
    }

    //get active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
    	System.out.println("getting active quizes");
        return this.quizService.getActiveQuizzes();
    }

    //get active quizzes of category
    @GetMapping("/category/active/{id}")
    public List<Quiz> getActiveQuizzes(@PathVariable("id") Long id) {
        Category category = new Category();
        category.setCid(id);
        System.out.println("getting active quizes of category");
        return this.quizService.getActiveQuizzesOfCategory(category);
    }

	
	

}
