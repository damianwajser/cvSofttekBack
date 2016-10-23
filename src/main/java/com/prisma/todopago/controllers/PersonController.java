package com.prisma.todopago.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prisma.todopago.model.Person;
import com.prisma.todopago.repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController extends AbstractController<Person>{
	
	@Autowired
	PersonRepository repository;
	@Autowired
	MongoOperations mongoOperation;
	
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> get() {
    	Collection<Person> persons = repository.findAll();
    	return super.collectionResult(persons);
    }
    @RequestMapping(method = RequestMethod.GET, path="/count")
    public Long getByTech(@RequestParam(value="tech") String[] techs) {
		Query q = new Query();
		Criteria[] criterias = new Criteria[techs.length];
		for (int i=0; i<techs.length;i++) {
			Criteria criteria = Criteria.where("cvString").regex(".*"+techs[i]+".*","i");
			criterias[i] = criteria;			
		}
		
		q.addCriteria(new Criteria().orOperator(criterias));
    	Long userTest1 = mongoOperation.count(q, Person.class);
		return userTest1;
    }
}
