package com.capg.mms.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.Movie;
import com.capg.mms.repository.MovieRepository;

@Repository
public class MovieDao {

	@Autowired
	private MovieRepository movieRepository ;
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie) ;
	}

	public List<Movie> getMovie() {
		List<Movie> movies = movieRepository.findAll() ;
		Collections.reverse(movies) ;
		return movies;
	}

	public String deleteMovie(long Id) {
		movieRepository.deleteById(Id);
		return "Movie Deleted Successfully!" ;
	}
	
	public Optional<Movie> findById(long id) {
		return movieRepository.findById(id) ;
	}
	
	public Movie save(Movie m) {
		return movieRepository.save(m) ;
	}

	public Movie findOne(long Id){
		return movieRepository.findById(Id).get();
	}
}
