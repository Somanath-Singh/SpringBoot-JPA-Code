package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	//select mid,mname,year,rating from sp_data_movie1 where mname='?';
	public List<Movie> findByMnameEquals(String name);
	public List<Movie> findBymname(String name);
	public List<Movie> findBymnameIs(String name);
	
	
	//select mid, mname,rating,year from so_data_movie where mname like 'R%';
	public Iterable<Movie> findByMnameStartingWith(String initChars); 
	
	//select mid, mname,rating,year from so_data_movie where mname like 'R%';
	public Iterable<Movie> findByMnameEndingWith(String lastChars); 
	
	//select mid, mname,rating,year from so_data_movie where mname like 'R%';
	public Iterable<Movie> findByMnameContaining(String chars); 


	//select mid, mname,rating,year from so_data_movie where mname like 'RRR';
	public Iterable<Movie> findByMnameEqualsIgnoreCase(String name); 
	
	//select mid, mname,rating,year from so_data_movie where mname like 'Pu%';
		public Iterable<Movie> findByMnameContainingIgnoreCase(String chars); 

		//select mid, mname,rating,year from so_data_movie1 where mname like 'R%';
			public Iterable<Movie> findByMnameLike(String chars); 
			
			
			//finder method with more multiple property based condition conditions
			
			//select mid, mname,rating,year from so_data_movie where mid>? and rating<?
			public Iterable<Movie> findByMidGreaterThanAndRatingLessThan(int startMid,float endRating);
			
			//select mid, mname,rating,year from so_data_movie where mname like'R%' or (rating between 4 and 4.6)
			public Iterable<Movie> findByMnameStartingWithOrRatingBetween(String mnameChars,float startRating,float endRating);
			
			//select mid, mname,rating,year from so_data_movie where year in(?,?) or (upper(mname) like upper(?) escape ?) and (rating between ? and ?)
			public Iterable<Movie> findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List<String> year,String chars,float startRating,float endRating);
			
			//select mid, mname,rating,year from so_data_movie where (mname not like ? escape ?)  or (year in (?,?)) order by mname asc
			public Iterable<Movie> findByMnameNotLikeOrYearInOrderByMnameAsc(String chars,List<String> years);
			
			//select mid, mname,rating,year from so_data_movie where (mname not like ? escape ?)  and (year in (?,?)) order by mname asc
			public Iterable<Movie> findByMnameNotLikeAndYearInOrderByMnameAsc(String chars,List<String> years);
			
			

}