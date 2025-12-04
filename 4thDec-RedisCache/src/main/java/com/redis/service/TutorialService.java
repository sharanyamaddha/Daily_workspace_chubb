package com.redis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.redis.model.Tutorial;
import com.redis.repository.TutorialRepository;

@Service

public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;

	@Cacheable("tutorials_all")
	public List<Tutorial> findAll() {
		doLongRunningTask();
		return tutorialRepository.findAll();
	}

	public Tutorial create(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	@Cacheable(value = "tutorial_by_id", key = "#id")
	public Optional<Tutorial> findById(String id) {
		doLongRunningTask();
		return tutorialRepository.findById(id);
	}

	@Cacheable(value = "tutorials_published", key = "#isPublished")
	public List<Tutorial> findByPublished(boolean isPublished) {
		doLongRunningTask();
		return tutorialRepository.findByPublished(isPublished);
	}

	@Cacheable(value = "tutorial_by_title", key = "#title")
	public List<Tutorial> findByTitle(String title) {
		doLongRunningTask();
		return tutorialRepository.findByTitle(title);
	}

	private void doLongRunningTask() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
