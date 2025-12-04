package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.model.Tutorial;
import com.redis.service.TutorialService;

@RestController
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;

	@PostMapping("/tutorial")
	public ResponseEntity<String> create(@RequestBody Tutorial tutorial) {
		Tutorial saved = tutorialService.create(tutorial);
		return ResponseEntity.status(201).body(saved.getId());

	}

	@GetMapping("/tutorials")
	public List<Tutorial> getAllTutorials() {
		return tutorialService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable String id) {
		return tutorialService.findById(id).map(tutorial -> ResponseEntity.ok(tutorial))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<List<Tutorial>> getTutorialByTitle(@PathVariable String title) {
		List<Tutorial> tutorials = tutorialService.findByTitle(title);

		if (tutorials.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(tutorials);
	}

	@GetMapping("/published")
	public List<Tutorial> getPublishedTutorials() {
		return tutorialService.findByPublished(true);
	}

}
