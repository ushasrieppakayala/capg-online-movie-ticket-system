package com.capg.mms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.dao.TheaterDao;
import com.capg.mms.entity.City;
import com.capg.mms.entity.Theater;
import com.capg.mms.exceptions.TheaterNotFoundException;

@Service
@Transactional
public class TheaterServiceImpl implements ITheaterService{
	@Autowired 
	private TheaterDao theaterdao;

	@Override
	public Theater saveTheater(Theater t) {
		return theaterdao.save(t);
	}

	@Override
	public List<Theater> getTheater() {
		return theaterdao.getTheater();
	}

	@Override
	public Theater findOne(long ID) {
		return theaterdao.findOne(ID);
	}

	@Override
	public String deleteTheater(Theater t) {
		Optional<Theater> th= theaterdao.findById(t.getTheaterId());
		 if(!th.isPresent())
		 {
			 throw new TheaterNotFoundException("Theater not found");
		 }
		
		return theaterdao.deleteTheater(t);
		
	}

	@Override
	public List<Theater> getTheaterByCityId(City c) {
		return theaterdao.getTheaterByCityId(c);		
	}
	
}