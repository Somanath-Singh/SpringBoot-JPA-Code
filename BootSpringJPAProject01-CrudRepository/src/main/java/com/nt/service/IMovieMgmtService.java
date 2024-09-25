package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Movie;

public interface IMovieMgmtService {
	
	public String registerMovie(Movie movie);
	
	public long fetchMoviesCount();
	
	public boolean checkMovieById(Integer mid);
	
	public Iterable<Movie> fetchAllMovies();
	
	public Iterable<Movie> fetchAllMoviesById(List<Integer> mids);
	
	public Movie fetchMovieById(Integer mid);
	
	
	public Optional<?> gatherMovieById(Integer mid);
	
	public String groupMovieRegistration(List<Movie>moviesList);
	
	//partialy update operation
	public String updateMovieDetails(Integer mid,String newyear,Float newRating);
	
	
	//full update operation
	public String updateMovie(Movie movie);
	
	
	public String removeMovieById(Integer mid);
	
	
	public String removeMovie(Movie movie);
	
	
	public String removeAllMovies();
	
	
	public String removeAllMoviesById(List<Integer> ids);

}
