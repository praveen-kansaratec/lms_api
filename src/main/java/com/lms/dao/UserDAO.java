package com.lms.dao;

import java.util.List;

import com.lms.model.User;




//public class loginDAO {

public interface UserDAO
{
	   int save (User log);
	 
    int update (User log, int id);
	 
	int delete (int id);
	 
	 List<User> getAll();
	 
	 User getById(int id);

	 User authenticateuser(String username, String password);

	

	List<String> save_details(String username, String password);

	
}
