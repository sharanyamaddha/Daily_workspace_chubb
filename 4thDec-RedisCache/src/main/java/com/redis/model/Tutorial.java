package com.redis.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Tutorial implements Serializable  {

	@Id
	private String id;
	private String title;
	private String description;
	private boolean published;
	
}
