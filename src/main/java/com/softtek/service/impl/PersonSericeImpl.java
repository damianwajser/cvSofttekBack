package com.softtek.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.softtek.model.Person;
import com.softtek.repository.PersonRepository;
import com.softtek.service.PersonService;

@Service
public class PersonSericeImpl implements PersonService {
	@Autowired
	private PersonRepository repository;
	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public Collection<Person> findAll() {
		Collection<Person> persons = repository.findAll();
		return persons;
	}

	@Override
	public Long countByTechs(String[] techs) {
		Query q = new Query();
		Criteria[] criterias = new Criteria[techs.length];
		for (int i = 0; i < techs.length; i++) {
			Criteria criteria = Criteria.where("cvString").regex(".*" + techs[i] + ".*", "i");
			criterias[i] = criteria;
		}
		q.addCriteria(new Criteria().orOperator(criterias));
		Long count = mongoOperation.count(q, Person.class);
		return count;
	}
}
