package com.softtek.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Person")
public class Person {

	@Id
	private String id;

	private String name;
	
	private String cvString;

	public Person(String id, String name, String cvString) {
		super();
		this.id = id;
		this.name = name;
		this.cvString=cvString;
	}

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCvString() {
		return cvString;
	}

	public void setCvString(String cvString) {
		this.cvString = cvString;
	}

}