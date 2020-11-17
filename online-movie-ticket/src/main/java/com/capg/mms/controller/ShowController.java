package com.capg.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.entity.Movie;
import com.capg.mms.entity.Show;
import com.capg.mms.entity.Theater;
import com.capg.mms.service.IMovieService;
import com.capg.mms.service.IShowService;


@RestController
@CrossOrigin("*")
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private IShowService showService ;
	
	@Autowired
	private IMovieService movieService ;
	 	
	@GetMapping("/movie/{id}")
	public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){
		
		Movie theMovie = showService.findOne(id);
	
		return showService.fetchByMovie(theMovie);
	}
	
	@PostMapping("/{theaterId}/{movieId}")
	public Show addingShow(@PathVariable(value ="theaterId") long theaterId,@PathVariable(value ="movieId") long movieId, @RequestBody Show requestData) {
		Theater theTheater = showService.findOneById(theaterId);
		Movie theMovie = showService.findOne(movieId);
		Show theShow = new Show();
		theShow.setShow_time(requestData.getShow_time());
		theShow.setTheMovie(theMovie);
		theShow.setTheTheater(theTheater);
		return showService.addShow(theShow);
	}
	

	@GetMapping("/show/{movieId}")
	public Show getShow(@PathVariable(value = "movieId") long movieId) {
		Movie movie = movieService.findMovieById(movieId) ;
		List<Show> s = movie.getShow() ;
		return s.get(0) ;
	}
	

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> deleteMovie(@PathVariable(value= "Id") long Id){
		return new ResponseEntity<String>(showService.deleteShow(Id), HttpStatus.OK) ;
	}
}
