package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Movie;
import com.nt.repository.IMovieRepo;

@SpringBootApplication
public class BootDataJpaProject06FinderMethodApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject06FinderMethodApplication.class, args);
	
	IMovieRepo repo=ctx.getBean(IMovieRepo.class);
	
	System.out.println(repo.getClass());
	
	System.out.println("========@Query method=================");
	
	
	Movie movie =new Movie();
	movie.setMname("Radhe");
	System.out.println(repo.save(movie).getMid()+"---------------object saved");

	
	
	
	}  
	
	
	}   
	
	
