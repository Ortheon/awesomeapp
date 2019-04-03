package com.eflechowicz.moviemanager.moviemicroservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	@Id
	private String id;
	@Size(min = 3, max = 50)
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String title;
	private float rating;
	private String director;
	private String actors;
	private Timestamp createdAt;

	public Movie() {
	}

	public Movie(String id, String title, float rating) {
		this.id = id;
		this.title = title;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Movie {" +
				"Id='" + id + '\'' +
				", Title='" + title + '\'' +
				", Rating='" + rating + '\'' +
				", Director='" + director + '\'' +
				", Actors='" + actors + '\'' +
				", createdAt=" + createdAt +
				'}';
	}

}