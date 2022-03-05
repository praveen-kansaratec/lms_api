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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lms.model.exam.User;
import com.lms.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserService lDAO;

	// getting user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<Map> getUserById(@PathVariable("id") long id) {
		Map<String, Object> response = new HashMap<>();

		User userObj = lDAO.getById(id);
		System.out.println("getting user by id");
		if (userObj != null) {
			response.put("data", userObj);
			response.put("status", "GETTING USER DETAILS SUCCESSFULLY");
		} else {
			response.put("status", "FAIL");
			response.put("error", "CAN NOT FIND USER");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// registration
	@PostMapping("/user")
	public ResponseEntity<Map> saveUser(@RequestBody User log) {
		Map<String, Object> response = new HashMap<>();
		User userObj = lDAO.save(log);
		System.out.println("Registered a user successfully");
		if (userObj != null) {
			response.put("data", userObj);
			response.put("status", "REGISTERED USER SUCCESSFULLY");
		} else {
			response.put("status", "FAIL");
			response.put("error", "CAN NOT REGISTERED");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// login
	@PostMapping("/user/authenticate")
	public ResponseEntity<Map> authenticateuser(@RequestBody User log) {
		Map<String, Object> response = new HashMap<>();
		User userObj = lDAO.authenticateuser(log.getUsername(), log.getPassword());
		if (userObj != null) {
			response.put("data", userObj);
			response.put("status", "SUCCESS");
		} else {
			response.put("status", "FAIL");
			response.put("error", "Invalid Username Password");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable("id") Long id) {
		System.out.println("deleting user by id successfully");
		this.lDAO.delete(id);

	}

}
