package com.capg.mms.service;

import java.util.List;

import com.capg.mms.entity.City;
import com.capg.mms.entity.Theater;

public interface ITheaterService {
	public Theater saveTheater(Theater t);
	public List<Theater> getTheater();
	public Theater findOne(long ID);
	public String deleteTheater(Theater t);
	public List<Theater> getTheaterByCityId(City c);

}