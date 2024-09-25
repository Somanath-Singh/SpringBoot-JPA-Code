package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;
import com.nt.view.Resultview;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	public Iterable<Resultview> findByMidGreaterThanEqualAndMidLessThanEqual(int startmid,int endmid);
			

}