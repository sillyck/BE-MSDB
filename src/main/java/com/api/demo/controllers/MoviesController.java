package com.api.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.models.Movies;
import com.api.demo.services.MoviesService;



@RestController
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	MoviesService moviesService;
	
	//localhost:8080/movies
	@GetMapping
	public ArrayList<Movies> getAllMovies(){
		return moviesService.getMovies();
	}
	
	//localhost:8080/movies
	@PostMapping
	public Movies saveMovie(@RequestBody Movies movies) {
		return moviesService.saveMovie(movies);
	}
	
	//localhost:8080/movies/1
	@GetMapping(path="/{id}")
	public Optional<Movies> getMovieId(@PathVariable("id") Long id){
		return moviesService.getMovieById(id);
	}
	
	//localhost:8080/movies/query?genre=Sci-Fi
	@GetMapping(path="/query")
	public ArrayList<Movies> getMoviesGenre(@RequestParam("genre") String genre){
		return moviesService.getMovieByGenre(genre);
	}
	
	//localhost:8080/movies/1
	@DeleteMapping(path="/{id}")
	public String deleteMoviesId(@PathVariable("id") Long id) {
		boolean ok = moviesService.deleteMovie(id);
		if(ok) {
			return "Movie with the id:" + id + " deleted correctly";
		}else {
			return "Could not delete the movie with the id:" + id;
		}
	}
	
	//localhost:8080/movies/valoration=9.3
	@GetMapping(path="/valoration={valoration}")
	public ArrayList<Movies> getMoviesByValoration(@PathVariable("valoration") float valoration){
	    return moviesService.getMoviesValoration(valoration);
	}

	
}
