package com.redis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.redis.model.Tutorial;


public interface TutorialRepository extends MongoRepository<Tutorial, String>{

	List<Tutorial> findByPublished(boolean isPublished);

	List<Tutorial> findByTitle(String title);



}
