package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	
	@Query("update Movie set rating=:newRating where mname=:name")
	@Modifying
	@Transactional
	public int modifyRatingByMovieName(float newRating,String name);
	
	
	@Query("delete from Movie where rating=:rating")
	@Modifying
	@Transactional
	public int deleteMovieByRating(float rating);
	
}