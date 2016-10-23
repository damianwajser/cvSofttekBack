package com.softtek.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Tech")
public class Tech {

	@Id
	private String id;
	private String name;

	public Tech(String id, String name) {
		super();
		this.id = id;
		this.setName(name);
	}

	public Tech() {

	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
