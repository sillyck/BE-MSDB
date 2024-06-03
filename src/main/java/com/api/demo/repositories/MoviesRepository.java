package com.api.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.demo.models.MoviesModel;

@Repository
public interface MoviesRepository extends CrudRepository<MoviesModel, Long> {

}
