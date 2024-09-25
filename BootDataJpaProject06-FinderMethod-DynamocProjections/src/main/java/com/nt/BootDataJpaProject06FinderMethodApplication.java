package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IMovieRepo;
import com.nt.view.Resultview1;
import com.nt.view.Resultview2;
import com.nt.view.Resultview3;
import com.nt.view.Resultview4;

@SpringBootApplication
public class BootDataJpaProject06FinderMethodApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject06FinderMethodApplication.class, args);
	
	IMovieRepo repo=ctx.getBean(IMovieRepo.class);
	
	System.out.println(repo.getClass());
	
	System.out.println("========Finder method=================");
	
	
	System.out.println("Repository iml class name::"+repo.getClass());
	Iterable<Resultview1> list=repo.findByMnameIn(List.of("RRR","Puspha"), Resultview1.class);
	
	list.forEach(view->{
		System.out.println("dynamic model class name ::"+view.getClass());
		System.out.println(view.getMid()+"  "+view.getMname());
	});
	
	System.out.println("---------------------------------------------");
	
	repo.findByMnameIn(List.of("RRR"), Resultview2.class).forEach(view->{
		System.out.println("dynamic model class name ::"+view.getClass());
		System.out.println(view.getMid()+"  "+view.getMname()+"   "+view.getRating());
	});
	
System.out.println("---------------------------------------------");
	
	repo.findByMnameIn(List.of("RRR"), Resultview3.class).forEach(view->{
		System.out.println("dynamic model class name ::"+view.getClass());
		System.out.println(view.getYear());
	});
	
	
System.out.println("---------------------------------------------");
	
	repo.findByMnameIn(List.of("RRR"), Resultview4.class).forEach(view->{
		System.out.println("dynamic model class name ::"+view.getClass());
		System.out.println(view.getMid()+"  "+view.getMname()+"   "+view.getYear());
	});
	
	
	
	}  
	
	
	}   
	
	
