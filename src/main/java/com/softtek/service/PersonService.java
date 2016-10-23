package com.softtek.service;

import java.util.Collection;

import com.softtek.model.Person;

public interface PersonService {

	Collection<Person> findAll();

	Long countByTechs(String[] techs);

}
