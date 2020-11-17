package com.capg.mms.service;

import java.util.List;

import com.capg.mms.entity.Movie;

public interface IMovieService {

public Movie addMovie(Movie movie) ;
	
	public List<Movie> getMovie() ;
	
	public String deleteMovie(long Id) ;
	
	public Movie findMovieById(long Id) ;
}
