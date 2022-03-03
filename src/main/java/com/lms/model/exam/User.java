package com.lms.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {

	
//	 public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error,String message, Object responseObj) {
//	        Map<String, Object> map = new HashMap<String, Object>();
//	        try {
//	            map.put("timestamp", new Date());
//	            map.put("status", status.value());
//	            map.put("isSuccess", error);
//	            map.put("message", message);
//	            map.put("data", responseObj);
//
//	            return new ResponseEntity<Object>(map,status);
//	        } catch (Exception e) {
//	            map.clear();
//	            map.put("timestamp", new Date());
//	            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//	            map.put("isSuccess",false);
//	            map.put("message", e.getMessage());
//	            map.put("data", null);
//	            return new ResponseEntity<Object>(map,status);
//	        }
//	    }
//	
//	
//	
//	
//	
//	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@NotNull
	@Size(min = 2, max = 30)
	private String username;
	
	@NotNull
	@Column(unique = true)
	private String password;
	
	@NotNull
	private String first_name;
	
	@NotNull
	private String last_name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String phone;
	
	private String role = "NORMAL";
	
	
	
	public User(Long id, String username, String password, String first_name, String last_name, String email,
			String phone, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}
		
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	}
	
	
