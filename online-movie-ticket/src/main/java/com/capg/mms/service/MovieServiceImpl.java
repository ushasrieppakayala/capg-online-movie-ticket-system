package com.capg.mms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.dao.MovieDao;
import com.capg.mms.entity.Movie;
import com.capg.mms.exceptions.MovieNotFound;

@Service
public class MovieServiceImpl implements IMovieService{

	@Autowired
	private MovieDao movieDao ;
	
	@Override
	public Movie addMovie(Movie m) {
		
		return movieDao.save(m) ;
	}

	
	@Override
	public List<Movie> getMovie() {
		List<Movie> movies = movieDao.getMovie() ;
		if(movies.size() == 0) {
			throw new MovieNotFound("Oops! No movies are avilable currently.") ;
		}
		return movies ;
	}

	
	@Override
	public String deleteMovie(long Id) {
		Optional<Movie> m = movieDao.findById(Id) ;
		if(!m.isPresent()) {
			throw new MovieNotFound("No movie present for ID: " + Id) ;
		}
		return movieDao.deleteMovie(Id) ;
	}

	
	@Override
	public Movie findMovieById(long Id){
		Optional<Movie> movie = movieDao.findById(Id) ;
		if(!movie.isPresent()) {
			throw new MovieNotFound("No movie present for ID: " + Id) ;
		}
		return movie.get() ;
	}

}
