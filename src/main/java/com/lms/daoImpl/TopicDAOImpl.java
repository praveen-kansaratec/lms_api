package com.lms.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lms.dao.TopicDAO;
import com.lms.model.Topic;


@Repository
public class TopicDAOImpl implements TopicDAO{

	@Autowired
	   JdbcTemplate jdbcTemplate;
		@Override
		public int save(Topic topic) {
		return	jdbcTemplate.update("INSERT INTO tbl_topic(id,name) VALUES (?,?)",new Object[] 
					{topic.getId(),topic.getName()} );
			
		}

		@Override
		public int update(Topic topic, int id) {
			// TODO Auto-generated method stub
			return jdbcTemplate.update("UPDATE  tbl_topic SET id = ? ,name =? WHERE id = ? ",
					new Object [] {topic.getId(),topic.getName(),id});
		}

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			return  jdbcTemplate.update("DELETE FROM tbl_topic WHERE id=?",id);
		}

		@Override
		public List<Topic> getAll() {
		return	jdbcTemplate.query("SELECT * FROM tbl_topic ", new BeanPropertyRowMapper<Topic>(Topic.class));
		
		}

		@Override
		public Topic getById(int id) {
			
			return jdbcTemplate.queryForObject("SELECT * FROM tbl_topic WHERE id = ? ", new BeanPropertyRowMapper<Topic>(Topic.class),id);
			
		}
	
	
	
	
	
}
