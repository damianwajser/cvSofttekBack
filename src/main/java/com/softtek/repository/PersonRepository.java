package com.softtek.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
}
