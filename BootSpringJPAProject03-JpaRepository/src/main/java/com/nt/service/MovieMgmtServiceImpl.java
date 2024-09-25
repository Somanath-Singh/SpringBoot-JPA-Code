package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	
	
	//all ids are should be present int the table then it perform batch delete operation
	
//	@Override
//	public String removeMoviesById(List<Integer> ids) {
//
//		List<Movie> list=movieRepo.findAllById(ids);
//		long count=list.size();
//		if(ids.size()!=0 && ids.size()==count) {
//			movieRepo.deleteAllByIdInBatch(ids);
//			
//			return count+" no of records are deleted";
//			
//		}
//		else
//			return "No ids are available or either all  or some ids are nt available to delete";
//		
//	}
	
	//what ever ids are present that are only delete
	
	@Override
	public String removeMoviesById(List<Integer> ids) {

		List<Movie> list=movieRepo.findAllById(ids);
		long count=list.size();
		movieRepo.deleteAllByIdInBatch(ids);
			
		return count+" no of records are deleted";
		
	}
	
	@Override
	public List<Movie> searchMoviesByMovie(Movie movie, boolean asc, String... props) {

		Example example=Example.of(movie);
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		List<Movie> list=movieRepo.findAll( example,sort);
		return list;
	}


	//depricated method
	@Override
	public Movie searchMovieByid(Integer id) {

		Movie movie=movieRepo.getById(id);
		if(movie==null)
			throw new IllegalArgumentException("given movie is not available");
		else
			return movie;
		
	}
	
	}
	

