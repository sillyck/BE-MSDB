package com.api.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.demo.models.Movies;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Long> {
	public abstract ArrayList<Movies> findByGenre(String genre);
	public abstract ArrayList<Movies> findByValoration(float valoration);
	public abstract ArrayList<Movies> findMoviesByValorationBetween(float min, float max);
	
}
