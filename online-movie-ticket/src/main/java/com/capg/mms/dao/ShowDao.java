package com.capg.mms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.Movie;
import com.capg.mms.entity.Show;
import com.capg.mms.repository.ShowRepository;

@Repository
public class ShowDao {

	@Autowired
	private ShowRepository showRepository ;
	
	public Show addShow(Show show) {
		return showRepository.save(show) ;
	}

	public List<Show> getShow() {
		return showRepository.findAll() ;
	}

	public String deleteShow(long s) {
		showRepository.deleteById(s);
		return "Show Deleted Successfully!" ;
	}
	
	public Optional<Show> findById(long showId) {
		return showRepository.findById(showId) ;
	
	}
	
	public Show findOne(long Id){
		return showRepository.findById(Id).get() ;
	}

	public Show save(Show s) {
		return showRepository.save(s) ;
	}

	public List<Show> findBytheMovie(Movie m) {
		return showRepository.findBytheMovie(m) ;
	}

	public Show getOne(long id) {
		
		return showRepository.getOne(id);
	}

}
