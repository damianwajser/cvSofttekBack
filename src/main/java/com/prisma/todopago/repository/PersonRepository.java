package com.prisma.todopago.repository;


import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.prisma.todopago.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	@Query(value = "{cvString: ?0}")
	Collection<Person> findLikeCvString(String tech);
}
