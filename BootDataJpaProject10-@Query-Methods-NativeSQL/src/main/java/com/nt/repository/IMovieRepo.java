package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.model.Movie;

@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {

	
	
	@Query(value="INSERT INTO SP_DATA_MOVIE VALUES(SP_ENO_SEQ.NEXTVAL,?,?,?)" ,nativeQuery=true)
	@Modifying
	public int registerMovies(String name,float newRating,String year);
	
//	@Query(value="INSERT INTO SP_DATA_MOVIE VALUES(?,?,?,?)" ,nativeQuery=true)
//	@Modifying
//	public int registerMovies(int mid,String name,float newRating,String year);
	
	@Query(value="SELECT SYSDATE FROM DUAL" ,nativeQuery=true)
	public String fetchSysDate();
	
}