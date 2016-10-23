package com.softtek.repository;


import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.softtek.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	@Query(value = "{cvString: ?0}")
	Collection<Person> findLikeCvString(String tech);
}
