package com.softtek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.model.Tech;

public interface TechRepository extends MongoRepository<Tech, String>{

}
