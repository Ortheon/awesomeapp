package com.eflechowicz.moviemanager.moviemicroservice.controller;

import com.eflechowicz.moviemanager.moviemicroservice.model.Movie;
import com.eflechowicz.moviemanager.moviemicroservice.service.MovieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/movies")
public class MovieController{

	@Autowired
	private MovieService service;

//	@Autowired
////	private SanitizeClient reviewClient;

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public List<Movie> getMovies() {
		return service.getMovies();
}
	@RequestMapping(value = "/rating/asc", method = RequestMethod.GET)
	public List<Movie> getMovieByRatingAsc(){
		return service.getMovieByRatingAsc();
	}
	
	@RequestMapping(value = "/rating/desc", method = RequestMethod.GET)
	public List<Movie> getMovieByRatingDesc(){
		return service.getMovieByRatingDesc();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Movie> getMovieById(@PathVariable String id) {
		return service.getMovieById(id);
	}
	
	@RequestMapping(value = "/byTitle/{title}", method = RequestMethod.GET)
	public Movie getMovieByTitle(@PathVariable String title) {
		return service.getMovieByTitle(title);
	}
	@PostMapping(value = "/movies")
	public Movie addMovie(@Valid @RequestBody Movie entity) {
		return service.createMovie(entity);
	}
	
	@RequestMapping(value = "/{title}", method=RequestMethod.DELETE)
	public Movie deleteMovie(@PathVariable String title) {
		return service.deleteMovie(title);
	}
	
}