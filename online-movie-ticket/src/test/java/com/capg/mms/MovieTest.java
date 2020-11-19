package com.capg.mms;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capg.mms.dao.MovieDao;
import com.capg.mms.entity.Movie;
import com.capg.mms.service.IMovieService;


@SpringBootTest
public class MovieTest {

	@Autowired
	private IMovieService movieService ;
	
	@MockBean
	private MovieDao movieDao ;
	
    RestTemplate restTemp ;
		
	@BeforeEach
	public void setup()
	{
			restTemp = new RestTemplate() ;
	}
		
	@Test
	public void testAddMovie() 
	{
		Movie movie = new Movie("usha", "ushaDir", "ushaDesc", "ushaImg") ;
			
		ResponseEntity<Movie> movieResp = restTemp.postForEntity("http://localhost:9090/movie/addMovie", movie, Movie.class) ;
			
		assertEquals(201 , movieResp.getStatusCodeValue());		
		
	}
		
	@Test
	public void testAllMovie()
	{
			
		ResponseEntity<Movie> movieResp = restTemp.getForEntity("http://localhost:9090/movie/allMovies", Movie.class) ;
			
			assertEquals(200, movieResp.getStatusCodeValue());
	}

	@Test
	public void testAllMovies() {
		when(movieDao.getMovie()).thenReturn(Stream.of(new Movie("MelbMovie", "MelbDir", "MilbDesc", "MelbImg"),
				new Movie("SelbMovie", "SelbDir", "SilbDesc", "SelbImg")).
				collect(Collectors.toList())) ;
		
		assertEquals(2, movieService.getMovie().size());
	}
	

	
	@Test
	public void testDeleteMovie() {
		long id = 200L ;
		Movie movie = new Movie(200,"MelbMovie", "MelbDir", "MilbDesc", "MelbImg") ;
		Optional<Movie> movieOptional = Optional.of(movie) ;		
		when(movieDao.findById(id)).thenReturn(movieOptional) ;
		
		movieService.deleteMovie(id) ;
		
		verify(movieDao, times(1)).deleteMovie(id) ;	
	}
	
}