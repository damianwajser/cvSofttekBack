package com.softtek.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.softtek.model.Count;
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
	public Count countByTechs(String[] techs) {
		Query q = new Query();
		Criteria[] criterias = buildCriteriaByTech(techs);
		q.addCriteria(new Criteria().andOperator(criterias));
		Long count = mongoOperation.count(q, Person.class);
		Count c = new Count(count);
		c.setCantPaginas(count / Count.CANT_PAGE);
		return c;
	}

	private Criteria[] buildCriteriaByTech(String[] techs) {
		Criteria[] criterias = new Criteria[techs.length];
		for (int i = 0; i < techs.length; i++) {
			Criteria criteria = Criteria.where("cvString").regex(".*" + techs[i] + ".*", "i");
			criterias[i] = criteria;
		}
		return criterias;
	}

	@Override
	public Collection<Person> getByTechs(String[] techs, int page) {
		Query q = new Query();
		q.fields().exclude("cvString");
		q.skip(page*Count.CANT_PAGE);//desde el documento que comienza
		q.limit(Count.CANT_PAGE);//catidad por pagina
		Criteria[] criterias = buildCriteriaByTech(techs);
		q.addCriteria(new Criteria().andOperator(criterias));
		Collection<Person> person = mongoOperation.find(q, Person.class);
		return person;
	}

	@Override
	public Person findById(String id) {
		Person p = repository.findOne(id);
		return p;
	}

	
}
