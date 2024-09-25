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
	
	System.out.println("========@Query + @Modifying  method=================");
	
	
	System.out.println("updating "+repo.modifyRatingByMovieName(5.0f, "RRR")+" for moves");
	
	
	System.out.println("deleting "+repo.deleteMovieByRating(4.0f)+" for moves");
	
	}  
	
	
	}   
	
	
