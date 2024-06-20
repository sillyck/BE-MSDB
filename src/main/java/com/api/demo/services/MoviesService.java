package com.api.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo.models.Movies;
import com.api.demo.repositories.MoviesRepository;

@Service
public class MoviesService {
	@Autowired
	MoviesRepository moviesRepository;
	
	//Obtenim totes les pel·lícules
	public ArrayList<Movies> getMovies(){
		return (ArrayList<Movies>) moviesRepository.findAll();
	}
	
	//Guardem una nova pel·lícula
	public Movies saveMovie(Movies movie) {
		return moviesRepository.save(movie);
	}
	
	//Obtenim la pel·lícula amb cert id
	public Optional<Movies> getMovieById(Long id){
		return moviesRepository.findById(id);
	}
	
	//Obtenim totes les pel·lícules amb aquest genere
	public ArrayList<Movies> getMovieByGenre(String genre){
		return moviesRepository.findByGenre(genre);
	}
	
	//Eliminem una pel·licula segons el seu id
	public boolean deleteMovie(Long id) {
		try {
			moviesRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}
	
	public ArrayList<Movies> getMoviesValoration(float valoration) {
	    return moviesRepository.findByValoration(valoration);
	}
	
}
