package com.eflechowicz.moviemanager.moviemicroservice.repository;

import com.eflechowicz.moviemanager.moviemicroservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MovieRepository extends MongoRepository<Movie, String> {
	
	Movie findByTitle(@Param("title") String title);
	Movie deleteByTitle(@Param("title") String title);
	List<Movie> findAllOrderByRating();
	List<Movie> findByRatingOrderByRating(Float rating);
	List<Movie> findAllByOrderByRatingAsc();
	List<Movie> findAllByOrderByRatingDesc();
}