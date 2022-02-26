package com.lms.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.lms.model.exam.Question;
import com.lms.model.exam.Quiz;
import com.lms.service.QuestionService;
import com.lms.service.QuizService;




@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	
	 @Autowired
	    private QuestionService service;

	    @Autowired
	    private QuizService quizService;

	    //add question
	    @PostMapping("/")
	    public ResponseEntity<Question> add(@RequestBody Question question) {
	    	 System.out.println("Addition of question Done successfully");
	        return ResponseEntity.ok(this.service.addQuestion(question));
	    }

	    //update the question
	    @PutMapping("/")
	    public ResponseEntity<Question> update(@RequestBody Question question) {
	    	System.out.println("Updation in question Done successfully");
	        return ResponseEntity.ok(this.service.updateQuestion(question));
	    }

	    //get all question of any quid
	    @GetMapping("/quiz/{id}")
	    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("id") Long id) {
//	        Quiz quiz = new Quiz();
//	        quiz.setqId(qid);
//	        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
//	        return ResponseEntity.ok(questionsOfQuiz);

	        Quiz quiz = this.quizService.getQuiz(id);
	        Set<Question> questions = quiz.getQuestions();
	        List list = new ArrayList(questions);
	        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
	            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
	        }
	        Collections.shuffle(list);
	        System.out.println("Getting questions by specified id from quiz");
	        return ResponseEntity.ok(list);


	    }


	    @GetMapping("/quiz/all/{id}")
	    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("id") Long id) {
	        Quiz quiz = new Quiz();
	        quiz.setqId(id);
	        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
	        System.out.println("Getting all questions from quiz");
	        return ResponseEntity.ok(questionsOfQuiz);

//	        return ResponseEntity.ok(list);


	    }


	    //get single question
	    @GetMapping("/{Id}")
	    public Question get(@PathVariable("Id") Long Id) {
	    	System.out.println("Getting question by id");
	        return this.service.getQuestion(Id);
	    }

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
	            Question question = this.service.get(q.getQuesId());
	            if (question.getAnswer().equals(q.getGivenAnswer())) {
	                //correct
	                correctAnswers++;

	                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
	                //       this.questions[0].quiz.maxMarks / this.questions.length;
	                marksGot += marksSingle;

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
