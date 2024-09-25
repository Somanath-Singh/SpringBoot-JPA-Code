package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;
import com.nt.repository.IMovieRepo;


@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired//injects the dynamically generated proxy class object
	private IMovieRepo movieRepo;//HAS-A property
	
	@Override
	public String registerMovie(Movie movie) {
		System.out.println("inMemory proxy class name::"+movieRepo.getClass()+"----------"+Arrays.toString(movieRepo.getClass().getInterfaces()));
		//use repo
		System.out.println("before saving::"+movie);
		Movie movie1=movieRepo.save(movie);
		System.out.println("after saving::"+movie1);
		
		return "Movie is registered with the id value::"+movie1.getMid();
	}

	@Override
	public long fetchMoviesCount() {
		
		return movieRepo.count();
	}

	@Override
	public boolean checkMovieById(Integer mid) {
		
		return movieRepo.existsById(mid);
	}

	@Override
	public Iterable<Movie> fetchAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Iterable<Movie> fetchAllMoviesById(List<Integer> mids) {
		return movieRepo.findAllById(mids);
	}

	/*@Override
	public Movie fetchMovieById(Integer mid) {

		Optional<Movie> opt=movieRepo.findById(mid);
		
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("RecordNot found");
	}*/
	
	
//	@Override
//	public Movie fetchMovieById(Integer mid) {
//
////		Optional<Movie> opt=movieRepo.findById(mid);
////		return opt.orElseThrow(()-> new IllegalArgumentException("Record not found"));
//		
//		//in a single line
//		
//		return movieRepo.findById(mid).orElseThrow(()-> new IllegalArgumentException("Record not found"));
//		
//	}
	
	@Override
	public Movie fetchMovieById(Integer mid) {
		return movieRepo.findById(mid).orElse(new Movie());//if record is available returns Entity object with data
																									//other wise empty entity object
	}

	@Override
	public Optional<?> gatherMovieById(Integer mid) {
		
		Optional<Movie> opt=movieRepo.findById(mid);
		if(opt.isEmpty())
		return Optional.empty();
		else
			return opt;
		
	}

	@Override
	public String groupMovieRegistration(List<Movie> moviesList) {

		Iterable<Movie> savedMovies=movieRepo.saveAll(moviesList);
		List<Integer> listids=new ArrayList();
		
		if(savedMovies!=null && ((List<Movie>) savedMovies).size()>0) {
			savedMovies.forEach(m->{
				listids.add(m.getMid());
			});//if
			
			return listids.toString()+"movies are saved";
			
		}
		return null;
	}

	@Override
	public String updateMovieDetails(Integer mid,String newyear, Float newRating) {

		Optional<Movie> opt=movieRepo.findById(mid);
		if(opt.isPresent()) {
			Movie movie=opt.get();
			movie.setYear(newyear);
			movie.setRating(newRating);
			
			movieRepo.save(movie);//always calls merge(-) to perform update operation
			
			return mid+" movie id is updated ";
			
		}
		else {
			return "Movie id is not updated";
		}

	}

	//all value updated
//	@Override
//	public String updateMovie(Movie movie) {
//		movieRepo.save(movie);
//		return "movie updated";
//	}

	
	@Override
	public String updateMovie(Movie movie) {

		Optional<Movie> opt=movieRepo.findById(movie.getMid());
		
		if(opt.isPresent()) {
			movieRepo.save(movie);
			return "movie is updated";
		}
		else {
			return "movie is not found to update";
		}
		
	}

	@Override
	public String removeMovieById(Integer mid) {

		Movie movie=movieRepo.findById(mid).orElseThrow(()->new IllegalArgumentException("movie not found"));
		movieRepo.delete(movie);
		return "record deleted";
		
	}
	
//	@Override
//	public String removeMovie(Movie movie) {
//		movieRepo.delete(movie);
//		return "Record deleted";
//	}
	
	public String removeMovie(Movie movie) {
	
		Optional<Movie> opt=movieRepo.findById(movie.getMid());
		
		if(opt.isPresent()) {
			movieRepo.delete(movie);
			return "Movie deleted";
		}
		else {
			return "Movie not found";
		}
	}
	
	@Override
	public String removeAllMovies() {

		long count=movieRepo.count();
		if(count!=0)
			movieRepo.deleteAll();
		
		return count+" no of record deleted";
		
	}
	
	@Override
	public String removeAllMoviesById(List<Integer> ids) {

		
		Iterable<Movie> it=movieRepo.findAllById(ids);
		long count=((List<Movie>) it).size();
		
		if(ids.size()!=0 && ids.size()==count)
		{
			movieRepo.deleteAllById(ids);
		
		return ((List<Movie>) it).size()+" no of records are deleted";
		}
		else {
			return "no ids are found to delete or either all or some ids are not available to delete ";
		}
		
	}
	
}

