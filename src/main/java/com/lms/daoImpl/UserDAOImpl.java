package com.lms.daoImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lms.dao.UserDAO;
import com.lms.model.User;




@Repository
public class UserDAOImpl implements UserDAO{



	@Autowired
	   JdbcTemplate jdbcTemplate;
		
	@Override
		public int save(User log) {
		return	jdbcTemplate.update("INSERT INTO tbl_user(username,password,firstname,lastname, email, phoneno,role) VALUES (?,?,?,?,?,?,?)",new Object[] 
					{log.getUsername(),log.getPassword(),log.getFirstname(),log.getLastname(),log.getEmail(),log.getPhoneno(),log.getRole()} );
			
		}

		@Override
		public int update(User log, int id) {
			// TODO Auto-generated method stub
			return jdbcTemplate.update("UPDATE  tbl_user SET username =?,password=?,firstname=?,lastname=?,email = ?,phoneno = ? ,role =?WHERE id = ? ",
					new Object [] {log.getUsername(),log.getPassword(),log.getFirstname(),log.getLastname(),log.getEmail(),log.getPhoneno(),log.getRole(),id});
		}
		
		
		@Override
		public User authenticateuser(String username,String password) {
			// TODO Auto-generated method stub
			//String sql = ";
			//User user = (User) jdbcTemplate.query(sql,);
		
			
			User user =  jdbcTemplate.queryForObject
	          ("SELECT * FROM lms_demo.tbl_user where username=? and password = ?",
	          new Object[] { username, password }, 
	          new BeanPropertyRowMapper<User>(User.class)); 
			
			
			
		 return user;
		 
			}
			
					
		
		

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			return  jdbcTemplate.update("DELETE FROM tbl_user WHERE id=?",id);
		}

		@Override
		public List<User> getAll() {
		return	jdbcTemplate.query("SELECT * FROM tbl_user ", new BeanPropertyRowMapper<User>(User.class));
		
		}

		@Override
		public User getById(int id) {
			
			return jdbcTemplate.queryForObject("SELECT * FROM tbl_user WHERE id = ? ", new BeanPropertyRowMapper<User>(User.class),id);
			
		}

		@Override
		public List<String> save_details(String username, String password) {
			// TODO Auto-generated method stub
			String[] ans = new String[2];
	        ans[0] = username;
	        ans[1] = password;
			return Arrays.asList(username,password);
	  
	        // returning array of elements
//	        return Arrays.asList(username,password);
		}

	
	
	
	
	
}
