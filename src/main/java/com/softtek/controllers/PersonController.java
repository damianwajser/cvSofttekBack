package com.softtek.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.model.Count;
import com.softtek.model.Person;
import com.softtek.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController extends AbstractController<Person>{
	
	@Autowired
	private PersonService service;
	
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> get() {
    	Collection<Person> persons = service.findAll();
    	return super.collectionResult(persons);
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/count")
    public ResponseEntity<Count> getCountByTech(@RequestParam(value="tech") String[] techs) {
    	Count count = service.countByTechs(techs);
    	return super.singleResult(count);
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/tech/page/{page}")
    public ResponseEntity<Collection<Person>> getByTech(@RequestParam(value="tech") String[] techs, @PathVariable(value="page") int page) {
    	Collection<Person> result = service.getByTechs(techs, page);
    	return super.collectionResult(result);
    }
    
}
