package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dao.UserDAO;
import com.lms.model.User;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserDAO lDAO;

	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("getting user");
		return lDAO.getAll();
	}

	@GetMapping("/user/{id}")
	public User getUserbyid(@PathVariable int id) {
		System.out.println("getting user by id");
		return lDAO.getById(id);
	}

	@PostMapping("/user")
	public String saveUser(@RequestBody User log) {
		System.out.println("Registered a user successfully");
	return	lDAO.save(log)+"No . of rows saved to the database";
		
	}

	
	@PostMapping("/user/authenticate")
	public User authenticateuser(@RequestBody  User log) {
		System.out.println("Login successfully");
		return	lDAO.authenticateuser(log.getUsername(),log.getPassword());
	
	}
	
	
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable int id) {
		System.out.println("deleting user by id successfully");
		return lDAO.delete(id) + " no of rows deleted from the database";
	}

}
