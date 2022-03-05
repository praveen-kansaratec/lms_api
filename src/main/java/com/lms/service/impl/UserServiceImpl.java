package com.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.lms.model.exam.User;
import com.lms.repo.UserRepository;
import com.lms.service.UserService;

@Repository
public class UserServiceImpl implements UserService{

	 @Autowired
	    private UserRepository userRepository;

	@Override
	public User save(User log) {
		// TODO Auto-generated method stub
		return this.userRepository.save(log);
	}

	@Override
	public User update(User log, int id) {
		// TODO Auto-generated method stub
		return this.userRepository.save(log);
	}

//	@Override
//	public void delete(long id) {
//		this.userRepository.deleteById(id);
//		
//	}
	@Override
	public void delete(long id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public List<User> getAll() {
		return this.userRepository.findAll(); 
	}

	@Override
	public User getById(long id) {
		return this.userRepository.findById(id).get();
		//return this.userRepository.getById(id);
	}

	@Override
	public User authenticateuser(String username, String password) {
		
		
		List<User> users =  this.userRepository.findByUsername(username);
		
		
		String status = "";
		for (User other : users)
		{
			if(password.equals(other.getPassword()))
			{
				
				return other;
				
			}
			
		}	
		return null;
			
	}

	
	
//	@Override
//	public User authenticateuser(String username, String password) {
//		return this.userRepository.findByUsername(username).get(0);
//	}
	
	
	@Override
	public List<User> save_details(String username, String password) {
		return this.userRepository.findAll();
	}
}