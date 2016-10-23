package com.softtek.service;

import java.util.Collection;

import com.softtek.model.Count;
import com.softtek.model.Person;

public interface PersonService {

	Collection<Person> findAll();

	Count countByTechs(String[] techs);

	Collection<Person> getByTechs(String[] techs, int page);

}
