package com.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lms.repo.QuizRepository;

@SpringBootApplication
public class UsertryApplication implements CommandLineRunner{

   
    @Autowired
    public QuizRepository quizRepository;

	public static void main(String[] args) {
		SpringApplication.run(UsertryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			  System.out.println("starting code");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
