package com.eflechowicz.moviemanager.moviemicroservice.service;

import com.eflechowicz.moviemanager.moviemicroservice.client.SanitizeClient;
import com.eflechowicz.moviemanager.moviemicroservice.model.Review;
import com.eflechowicz.moviemanager.moviemicroservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	MovieService movieService;
	SanitizeClient sanitizeClient;

	//	@Autowired
//	@Lazy
//	MovieClient movieClient;


	public Review addReview(@Valid Review entity, String title) {

//		entity.setContent(Sanitizer.sanitizer(entity.getContent()	,movieClient.getMovieByTitle(title).getDirector()));
//		entity.setApproval(true);

		List <Review> existingReviews = new ArrayList<>();
		if(reviewRepo.findAllByTitle(title)==null) {
			return reviewRepo.save(entity);
		}
		existingReviews.addAll(reviewRepo.findAllByTitle(title));
		existingReviews.add(entity);
		reviewRepo.saveAll(existingReviews);
		return (entity);
	}


	public List <Review> getReviews(String title) {
		return reviewRepo.findAllByTitle(title);
	}

	public Review sanitizeReview(Optional<Review> review) {
		Review entity = review.get();
		String director = movieService.getMovieByTitle(entity.getTitle()).getDirector();
		entity.setContent(sanitizeClient.sanitizeReview(entity));
		System.out.println("wypierdoli czy nie!");
		entity.setApproval(true);
		return reviewRepo.save(entity);
	}

	public Optional<Review> getReviewById(String id) {
		return reviewRepo.findById(id);
	}

}
