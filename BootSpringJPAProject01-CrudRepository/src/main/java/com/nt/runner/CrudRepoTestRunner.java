package com.nt.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

//		//invoke service method
//		Movie movie =new Movie();
//		movie.setMname("RRR");
//		movie.setRating(4.5f);
//		movie.setYear("2022");
//		
//		try {
//			System.out.println(service.registerMovie(movie));
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//		}
		
		System.out.println("---------------------------");
		try {
			System.out.println("records count::"+service.fetchMoviesCount());
		}catch(Exception se) {
			se.printStackTrace();
		}
		
		System.out.println("---------------------------");
		try {
			System.out.println("is 2 mid movie available ?"+service.checkMovieById(1));
		}catch(Exception se) {
			se.printStackTrace();
		}
		
		System.out.println("-------------For finAll() method--------------");
		try {

			Iterable<Movie> list=service.fetchAllMovies();
			for(Movie movie1:list) { //enhanced for loop
				System.out.println(movie1);
			}
			
			System.out.println("---------------------------------");
			list.forEach(movie1->{//forEach() method
				System.out.println(movie1);
			});
			
			System.out.println("---------------------------------");
			list.forEach(movie1->System.out.println(movie1));//forEach() method
			
			System.out.println("---------------------------------");
			list.forEach(System.out::println);//forEach() method + static method reference
			
			System.out.println("---------------------------------");
			Arrays.asList(list).stream().forEach(System.out::println);//forEach method + streaming api+static method
			
			System.out.println("---------------------------------");
			
		}catch(Exception se) {
			se.printStackTrace();
		}
		
		System.out.println("-------for findAllById(-) method------------------------");
		try {
			List<Integer> idsList=new ArrayList();
			idsList.add(189);
			idsList.add(1);
			
			System.out.println("movies are ::"+service.fetchAllMoviesById(idsList));//java 9
			
			System.out.println("======================");
			
			System.out.println("Movies are::"+service.fetchAllMoviesById(List.of(189,1)));
			
			System.out.println("==========================");
			
			System.out.println("movies are::"+service.fetchAllMoviesById(Arrays.asList(189,1)));
			
		}catch(Exception se) {
			se.printStackTrace();
		}
		
		
//		System.out.println("------------for findById() method -----------------------------------");
//		try {
//			System.out.println("id 1 movie is ::"+service.fetchMovieByid(1));
//			//System.out.println("id 1 movie is ::"+service.fetchMovieByid(1)); //get exception "RecordNot found"
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//			System.out.println(se.getMessage());
//		}
		
		
		
		System.out.println("------------for findById() method -----------------------------------");
		try {
			System.out.println("1 movie id movie is::"+service.fetchMovieById(15));
		}
		catch(Exception se) {
			se.printStackTrace();
			System.out.println(se.getMessage());
		}
		
		
		System.out.println("------------for findById() method using Optional object-----------------------------------");
		try {
			
			Optional<?> opt=service.gatherMovieById(189);
			if(!opt.isEmpty())
			System.out.println("189 movie id movie is::"+service.gatherMovieById(189));
			else
				System.out.println("Record not found"+opt);
			
		}
		catch(Exception se) {
			se.printStackTrace();
			System.out.println(se.getMessage());
		}
		
		
		System.out.println("-----------for saveall() method -------------------");
		try {
			String result=service.groupMovieRegistration(List.of(new Movie("ABPL","2021",5.0f), 
																									new Movie("83","2021",4.6f), 
																									new Movie("Puspha","2021",4.0f)
																									));
			System.out.println(result);
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		//partial data updating
		System.out.println("------------for save(-) for update object operation method--------------------------");
		try {
			String result=service.updateMovieDetails(1, "2022", 4.2f);
			System.out.println(result);
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		
		//all data updating
		System.out.println("------------for save(-) for update object operation method--------------------------");
		try {
			Movie movie1=new Movie("RRR2","2022",5.0f);
			//movie.setMid(1);//if we not giving the movie id then it performs the insert operation
			movie1.setMid(1);
			String result=service.updateMovie(movie1);
			System.out.println(result);
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
		
		
//		System.out.println("----------------for deleteById(-) object operation------------------------");
//		try {
//			System.out.println(service.removeMovieById(2));
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//		}
		
		
//		System.out.println("----------------for delete(-) object operation------------------------");
//		try {
//			Movie movie=new Movie();
//			movie.setMid(303);
//			System.out.println(service.removeMovie(movie));
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//		}
		
//		System.out.println("----------------for deleteAll(-) for deleting all object operation------------------------");
//		try {
//			System.out.println(service.removeAllMovies());
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//		}
		
		System.out.println("----------------for deleteAllById(-) for deleting all objects operation --------------------------");
		try {
			System.out.println(service.removeAllMoviesById(List.of(552,553)));
		}
		catch(NullPointerException npe) {
			System.out.println("id(s) must not be null");
			npe.printStackTrace();
		}
		catch(Exception se) {
			se.printStackTrace();
		}

	}
	

	
}
