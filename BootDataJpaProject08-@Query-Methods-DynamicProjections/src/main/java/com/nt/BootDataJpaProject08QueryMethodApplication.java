package com.nt;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Movie;
import com.nt.repository.IMovieRepo;

@SpringBootApplication
public class BootDataJpaProject08QueryMethodApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject08QueryMethodApplication.class, args);
	
	IMovieRepo repo=ctx.getBean(IMovieRepo.class);
	
	System.out.println(repo.getClass());
	
	System.out.println("========@Query method=================");
	
	List<Movie> list=repo.searchMoviesByIdRange(400, 800);
	list.forEach(System.out::println);
	
	System.out.println("------------------------------------------");
	
	repo.searchMoviesByMnames("RRR","RRR","Puspha").forEach(System.out::println);
	
	
	System.out.println("------------------------------------------");
	
	repo.fetchMovieDetailsByratingsAndYear(4.0f, "2021", "2021", "2019").forEach(row->{
		
		for(Object val:row)
			System.out.print(val+"   ");
		
		System.out.println();
		
	});
	
	
	System.out.println("------------------------------------------");
	
	repo.fetchMoviesByYearRange("2021", "2022").forEach(System.out::println);
	
	System.out.println("------------------------------------------");
	
	//single row hql operations
	
	Movie movie=repo.fetchMoviedataByName("RRR");
	if(movie!=null)
		System.out.println("RRR movie details are ::"+movie);
	else
		System.out.println("Movie not found");
		
	System.out.println("------------------------------------------");
	
	Object data=repo.fetchMoviePartialDatabyMname("RRR");
	Object result[]=(Object[])data;
	for(Object val:result) {
		System.out.print(val+"  ");
	}
	
	
	System.out.println("------------------------------------------");
	
	String year=repo.fetchMovieSingleDatabyMname("RRR");
	
	System.out.println("RRR movie release date::"+year);
	
	System.out.println("------------------------------------------");
	
	System.out.println("Highest rating movies ::"+repo.fetchMaxRatingmovie());
	
	System.out.println("------------------------------------------");
	
	Object result1[]=(Object[])repo.fetchAggregateDataOnMovies();
	
	System.out.println("Max rating "+result1[0]);
	System.out.println("Min rating "+result1[1]);
	System.out.println("Avg rating "+result1[2]);
	System.out.println("Count of movies "+result1[3]);
	System.out.println("Sum of rating "+result1[4]);
	
	}  
	
	
	}   
	
	
