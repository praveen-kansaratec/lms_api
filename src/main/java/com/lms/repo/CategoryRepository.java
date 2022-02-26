package com.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.exam.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{

}
