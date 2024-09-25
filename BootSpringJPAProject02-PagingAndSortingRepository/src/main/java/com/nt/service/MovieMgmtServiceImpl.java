package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;


@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired//injects the dynamically generated proxy class object
	private IMovieRepo movieRepo;//HAS-A property
	
	
	
	@Override
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String... properties) {

		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		return movieRepo.findAll(sort);
		
	} 
	
	@Override
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String... props) {
		//create pageable object
		Pageable pageble=PageRequest.of(pageNo, pageSize,Sort.by(asc?Direction.ASC:Direction.DESC,props));
		//get requested page records
		Page<Movie> page=movieRepo.findAll(pageble);
		return page;
		
	}
	
	}
	

