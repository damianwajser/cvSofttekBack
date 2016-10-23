package com.softtek.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.model.Tech;
import com.softtek.repository.TechRepository;
import com.softtek.service.TechService;

@Service
public class TechServicesImpl implements TechService {
	
	@Autowired
	private TechRepository repository;

	
	@Override
	public Collection<Tech> findAll() {
		Collection<Tech> techs = repository.findAll();
		return techs;
	}


	@Override
	public Tech insert(Tech tech) {
		Tech result = repository.insert(tech);
		return result;
	}



}
