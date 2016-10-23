package com.softtek.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.model.Tech;
import com.softtek.service.TechService;

@RestController
@RequestMapping("/api/tech")
public class TechController extends AbstractController<Tech>{
	private TechService service;
}
