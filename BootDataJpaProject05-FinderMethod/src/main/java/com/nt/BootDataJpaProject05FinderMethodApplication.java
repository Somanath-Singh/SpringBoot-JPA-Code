package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IMovieRepo;

@SpringBootApplication
public class BootDataJpaProject05FinderMethodApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(BootDataJpaProject05FinderMethodApplication.class, args);
	
	IMovieRepo repo=ctx.getBean(IMovieRepo.class);
	
	System.out.println(repo.getClass());
	
	System.out.println("========Finder method=================");
	//all these 3 methods are same 
	repo.findByMnameEquals("RRR").forEach(System.out::println);	
	System.out.println("--------------------------------------------------------------");
	repo.findBymname("RRR").forEach(System.out::println);
	System.out.println("--------------------------------------------------------------");
	repo.findBymnameIs("RRR").forEach(System.out::println);
	System.out.println("--------------------------------------------------------------");
	
	
	System.out.println("--------------------------------------------------------------------");
	repo.findByMnameStartingWith("R").forEach(System.out::println);
	
	System.out.println("--------------------------------------------------------------------");
	repo.findByMnameEndingWith("R").forEach(System.out::println);
	
	System.out.println("--------------------------------------------------------------------");
	repo.findByMnameContaining("R").forEach(System.out::println);
	
	System.out.println("--------------------------------------------------------------------");
	repo.findByMnameEqualsIgnoreCase("Puspha").forEach(System.out::println);
	

	System.out.println("--------------------------------------------------------------------");
	repo.findByMnameContainingIgnoreCase("Pu").forEach(System.out::println);
	  
	
	System.out.println("--------------------------------------------------------------------");
	//repo.findByMnameLike("k%").forEach(System.out::println);
	//repo.findByMnameLike("_").forEach(System.out::println);
	//repo.findByMnameLike("%C%").forEach(System.out::println);
	repo.findByMnameLike("%2").forEach(System.out::println);
	
	
	System.out.println("==================finder methods with multiple properties based conditions================");
	repo.findByMidGreaterThanAndRatingLessThan(600, 4.6f).forEach(System.out::println);
	
	System.out.println("--------------------------------------------------------------------");
	
	repo.findByMnameStartingWithOrRatingBetween("R", 4f, 4.6f).forEach(System.out::println);
	
System.out.println("--------------------------------------------------------------------");
	
	repo. findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List.of("2021","2022"),"R", 4f, 4.6f).forEach(System.out::println);
	
	System.out.println("--------------------------------------------------------------------");
	
	repo.findByMnameNotLikeOrYearInOrderByMnameAsc("R%",List.of("2021","2022")).forEach(System.out::println);

System.out.println("--------------------------------------------------------------------");
	
	repo.findByMnameNotLikeAndYearInOrderByMnameAsc("R%",List.of("2021","2022")).forEach(System.out::println);

	
	
	}  
	
	
	}   
	
	
