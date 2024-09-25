package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;


@Component	
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {


//		System.out.println("-----------findAll(Sort sort)---------------------");
//		try {
//			Iterable<Movie> it=service.displayMoviesByOrder(false,"mid", "mname");
//			it.forEach(System.out::println);
//		}
//		catch(Exception se) {
//			se.printStackTrace();
//		}
		
		
		System.out.println("-----------findAll(Pageable pageable)---------------------");
		try {
			Page<Movie> page=service.generateReport(55, 545, true, "mname");
			if(!page.isEmpty()) {
				List<Movie> list=page.getContent();
				list.forEach(System.out::println);
			}
			else {
				System.out.println("no page found");
			}
			
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		
	}
	
}
