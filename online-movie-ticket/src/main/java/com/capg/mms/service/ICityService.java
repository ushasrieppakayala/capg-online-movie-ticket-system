package com.capg.mms.service;

import java.util.List;

import com.capg.mms.entity.City;

public interface ICityService {


	public City addCity(City city) ;
	
	public List<City> getCity() ;
	
	public String deleteCity(City city) ;
	
	public City findOne(long Id) ;
}
