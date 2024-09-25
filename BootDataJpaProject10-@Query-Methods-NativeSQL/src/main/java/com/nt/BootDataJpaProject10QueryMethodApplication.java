package com.nt;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Movie;
import com.nt.repository.IMovieRepo;

@SpringBootApplication
public class BootDataJpaProject10QueryMethodApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject10QueryMethodApplication.class, args);
	
	IMovieRepo repo=ctx.getBean(IMovieRepo.class);
	
	System.out.println(repo.getClass());
	
	System.out.println("========@Query + Native sql Query=================");
	
	
//	int result=repo.registerMovies(12,"Theri", 4.5f, "2019");
//	
//	System.out.println((result==0)?"movie not registered":"movie registered");
//	
	
	
	int result=repo.registerMovies("D16", 4.5f, "2019");
	
	System.out.println((result==0)?"movie not registered":"movie registered");
	
	
	System.out.println("----------------------------------------------------");
	
	System.out.println("system date and time ::"+repo.fetchSysDate());
	
	}  
	
	
	
	
	}   
	
	
