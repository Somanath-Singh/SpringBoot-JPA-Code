package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IMovieRepo;
import com.nt.view.Resultview;

@SpringBootApplication
public class BootDataJpaProject05FinderMethodApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject05FinderMethodApplication.class, args);
	
	IMovieRepo repo=ctx.getBean(IMovieRepo.class);
	
	System.out.println(repo.getClass());
	
	System.out.println("========Finder method=================");
	
	
	System.out.println("Repository iml class name::"+repo.getClass());
	Iterable<Resultview> it=repo.findByMidGreaterThanEqualAndMidLessThanEqual(400, 800);
	
	it.forEach(view->{
		System.out.println("dynamic model class name ::"+view.getClass());
		System.out.println(view.getMid()+"  "+view.getMname());
	});
	
	
	
	}  
	
	
	}   
	
	
