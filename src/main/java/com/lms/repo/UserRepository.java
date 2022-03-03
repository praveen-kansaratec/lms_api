package com.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.exam.User;



public interface UserRepository extends JpaRepository<User, Long>{
	public List<User> findByUsername(String username);

}
