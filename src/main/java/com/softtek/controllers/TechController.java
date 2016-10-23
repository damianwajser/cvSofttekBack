package com.softtek.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.model.Tech;
import com.softtek.service.TechService;

@RestController
@RequestMapping("/api/tech")
public class TechController extends AbstractController<Tech>{
	@Autowired
	private TechService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Tech>> get(){
		Collection<Tech> techs = service.findAll();
    	return super.collectionResult(techs);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Tech> save (@RequestBody Tech tech){
	
		Tech result = service.insert(tech);
		return super.singleResult(result);
	}
	
		
}
