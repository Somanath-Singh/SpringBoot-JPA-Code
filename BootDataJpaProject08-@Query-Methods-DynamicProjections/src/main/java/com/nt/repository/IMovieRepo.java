package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	/*
	@Query("from Movie where mid>=?1 and mid<=?2")
	public List<Movie> searchMoviesByIdRange(int start,int end);
	*/
	
//	@Query("from Movie where mid>=:min and mid<=:max")
//	public List<Movie> searchMoviesByIdRange(@Param("min") int start,@Param("max") int end);
	
	
	@Query("from Movie where mid>=:min and mid<=:max")
	public List<Movie> searchMoviesByIdRange(int min,int max);
	
	
	@Query("from Movie where mname in(:name1,:name2,:name3) order by mname asc")
	public List<Movie> searchMoviesByMnames(String name1,String name2,String name3);

	//================================Scalar Queries(Specific multiple col values)=========================
	
	@Query("select mid,mname,year from Movie where rating>=:rat and year in(:y1,:y2,:y3)")
	public List<Object[]> fetchMovieDetailsByratingsAndYear(float rat,String y1,String y2,String y3);
	
	
	@Query("select mname from Movie where year in(:y1,:y2)")
	public List<Object> fetchMoviesByYearRange(String y1,String y2);
	
	
	//Single row entity query
	
	@Query("from Movie where mname=:name") //assuming movie name are unique
	public Movie fetchMoviedataByName(String name);
	
	
	//Single row Scalar query giving specific multiple col values
	
	@Query("select mid,mname,year from Movie where mname=:name")
	public Object fetchMoviePartialDatabyMname(String name);
	
	//Single row Scalar query giving single specific col value
	
		@Query("select year from Movie where mname=:name")
		public String fetchMovieSingleDatabyMname(String name);
		
		
		//executing single aggregate function
		
		@Query("select max(rating) from Movie")
		public float fetchMaxRatingmovie();
		
		
		@Query("select max(rating),min(rating),avg(rating),count(*),sum(rating) from Movie")
		public Object fetchAggregateDataOnMovies();
	
	
	
	
}