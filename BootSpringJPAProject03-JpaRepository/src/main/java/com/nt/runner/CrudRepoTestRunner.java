package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;


@Component	
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("-----------------deleteAllByInBatch(-)-------------------");
		try {
			//null values are not allowed
			
			//System.out.println(service.removeMoviesById(List.of(602,603,604)));
			
			//null values are not allowed
			/*
			List<Integer> list=new ArrayList();
			list.add(702);
			list.add(703);
			list.add(604);
			
			System.out.println(service.removeMoviesById(list));
			*/
			
			//null values are allowed
			
//			List<Integer> ids=Arrays.asList(852,null);
//			System.out.println(service.removeMoviesById(ids));
			
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		
		System.out.println("----------------findAll(Example,Sort)------------------");
		try {
			Movie movie=new Movie();
			//movie.setMid(100);
			movie.setMname("Puspha");
			movie.setRating(4f);
			movie.setYear("2021");
			
			List<Movie> list=service.searchMoviesByMovie(movie, true, "mname");
			list.forEach(System.out::println);
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		
		//depricated method
		
//		System.out.println("----------getById(Integer id)--------------------------");
//		try {
//			System.out.println("853 movie details is ::"+service.searchMovieByid(853));
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//		}
		
	}
	
}
