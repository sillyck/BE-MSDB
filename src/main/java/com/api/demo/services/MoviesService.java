package com.api.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo.models.MoviesModel;
import com.api.demo.repositories.MoviesRepository;

@Service
public class MoviesService {
	@Autowired
	MoviesRepository moviesRepository;
	
	public ArrayList<MoviesModel> getMovies(){
		return (ArrayList<MoviesModel>) moviesRepository.findAll();
	}
	
	public MoviesModel saveMovie(MoviesModel movie) {
		return moviesRepository.save(movie);
	}
}
