package com.capg.mms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.entity.Movie;
import com.capg.mms.entity.Response;
import com.capg.mms.exceptions.MovieAlreadyPresent;
import com.capg.mms.exceptions.MovieNotFound;
import com.capg.mms.service.IMovieService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private IMovieService movieService;

	@ExceptionHandler(MovieAlreadyPresent.class)
	@PostMapping("/addMovie")
	public ResponseEntity<?> createMovie( @RequestBody Movie movie)  {
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(movieService.addMovie(movie), new Date()));
		}
		catch(MovieAlreadyPresent ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT) ;
		}
	}

	
	@ExceptionHandler(MovieNotFound.class)
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value = "Id") long Id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.deleteMovie(Id), new Date()));
		}
		catch(Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
		}
	}

	
	@GetMapping("/allMovies")
	public ResponseEntity<Response> getAllMovies() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.getMovie(), new Date()));
	}

	
	@PutMapping("/update/{ID}")
	public ResponseEntity<Response> updateMovie(@PathVariable(value = "ID") long ID,  @RequestBody Movie m) {
		Movie theMovie = movieService.findMovieById(ID);
		theMovie.setMovieName(m.getMovieName());
		theMovie.setMovieDirector(m.getMovieDirector());
		theMovie.setMovieDescription(m.getMovieDescription());
		theMovie.setMovieImg(m.getMovieImg());
		return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.addMovie(theMovie), new Date()));
	}

	
	@ExceptionHandler(MovieNotFound.class)
	@GetMapping("/{ID}")
	public ResponseEntity<?> getOneMovie(@PathVariable(value = "ID") long ID) {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.findMovieById(ID), new Date()));
		}
		catch(Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
		}
	}

}