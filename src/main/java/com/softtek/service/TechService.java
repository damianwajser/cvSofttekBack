package com.softtek.service;

import java.util.Collection;

import com.softtek.model.Tech;

public interface TechService {

	Collection<Tech> findAll();

	Tech insert(Tech tech);

}
