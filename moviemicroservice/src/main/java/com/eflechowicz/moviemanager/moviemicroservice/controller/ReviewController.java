package com.eflechowicz.moviemanager.moviemicroservice.controller;

import com.eflechowicz.moviemanager.moviemicroservice.model.Review;
import com.eflechowicz.moviemanager.moviemicroservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;

//	@Autowired
//	private MovieClient movieClient;
	@PostMapping(value = "/{title}")
	public Review addReview(@Valid @RequestBody Review entity, @PathVariable(value = "title") String title) {
		System.out.println(entity.toString());
		System.out.println(title);
		return service.addReview(entity, title);
	}
	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public List<Review> getReviews(@PathVariable(value = "title") String title) {
		return service.getReviews(title);
	}
	@RequestMapping(value = "/byId/{id}", method = RequestMethod.GET)
	public Optional<Review> getReviewsById(@PathVariable(value = "id") String id) {
		return service.getReviewById(id);
	}

	@PostMapping(value = "/sanitize/{id}")
	public Review sanitizeReview(@PathVariable(value = "id") String id) {

		return service.sanitizeReview(service.getReviewById(id));
	}
}
