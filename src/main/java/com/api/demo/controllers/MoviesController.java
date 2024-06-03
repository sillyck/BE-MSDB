package com.api.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.demo.models.MoviesModel;
import com.api.demo.services.MoviesService;

@Controller
public class MoviesController {
	@Autowired
	MoviesService moviesService;
	
	@GetMapping("/movies")
	public String listAll(MoviesModel movies) {
		//TODO
	}
}
