package com.lms.dao;

import java.util.List;

import com.lms.model.Topic;

public interface TopicDAO {

	int save(Topic topic);

	int update(Topic topic, int id);

	int delete(int id);

	List<Topic> getAll();

	Topic getById(int id);

}
