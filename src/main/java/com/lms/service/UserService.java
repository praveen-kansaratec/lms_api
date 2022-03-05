package com.lms.service;

import java.util.List;
import com.lms.model.exam.User;

public interface UserService {

		public User save (User log);
		 
	    public User update(User log, int id);
		 
		public void  delete(long id);
		 
		public List<User> getAll();
	 
	 User getById(long id);

	 User authenticateuser(String username, String password);

	 List<User> save_details(String username, String password);
	
}
