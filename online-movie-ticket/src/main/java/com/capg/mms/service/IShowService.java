package com.capg.mms.service;

import java.util.List;

import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Movie;
import com.capg.mms.entity.Show;
import com.capg.mms.entity.Theater;

public interface IShowService {

public Show addShow(Show show) ;
	
	public List<Show> getShow() ;
	
	public String deleteShow(long s) ;
	
	public Movie findOne(long Id) ;
	
	public Show fetchById(long Id);
		
	public List<Show> fetchByMovie(Movie m) ;
	
	public Bookings getAvailableSeat(long showID);
	
	public Theater findOneById(long Id);
}
