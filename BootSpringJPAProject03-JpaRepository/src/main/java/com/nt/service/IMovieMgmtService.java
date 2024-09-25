package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	
	public String removeMoviesById(List<Integer> ids);
	
	public List<Movie> searchMoviesByMovie(Movie movie,boolean asc,String ...props);
	
	
	public Movie searchMovieByid(Integer id);
	
	
	
}
