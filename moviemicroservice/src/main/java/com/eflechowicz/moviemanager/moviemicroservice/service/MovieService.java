package com.eflechowicz.moviemanager.moviemicroservice.service;

import com.eflechowicz.moviemanager.moviemicroservice.model.Movie;
import com.eflechowicz.moviemanager.moviemicroservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieService {

	@Autowired
	MovieRepository movieRepo;
	
	
	public List<Movie> getMovies() {
		return movieRepo.findAll();
	}
	
	 public Optional<Movie> getMovieById(String id) {
		return movieRepo.findById(id);
	}
	 
	 public Movie createMovie( Movie entity) {
		 return movieRepo.save(entity);
	 }
	 
	 public Movie deleteMovie(String title) {
		 return movieRepo.deleteByTitle(title);
	 }

	public List<Movie> getMovieByRatingAsc() {
		return movieRepo.findAllByOrderByRatingAsc();
	}
	
	public List<Movie> getMovieByRatingDesc() {
		return movieRepo.findAllByOrderByRatingDesc();
	}

	public Movie getMovieByTitle(String title) {
		return movieRepo.findByTitle(title);
	}
}

