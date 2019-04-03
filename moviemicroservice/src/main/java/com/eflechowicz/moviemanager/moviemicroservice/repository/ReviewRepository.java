package com.eflechowicz.moviemanager.moviemicroservice.repository;


import com.eflechowicz.moviemanager.moviemicroservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface ReviewRepository extends MongoRepository<Review, String> {

	List<Review> findAllByTitle(@Param("title")String title);
	Review deleteByTitle(@Param("title") String title);
	void deleteById(@Param("id") String id);
	Optional<Review> findById(@Param("id")String id);
}