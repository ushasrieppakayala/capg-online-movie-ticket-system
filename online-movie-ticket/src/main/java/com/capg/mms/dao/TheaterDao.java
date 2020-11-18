package com.capg.mms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.City;
import com.capg.mms.entity.Theater;
import com.capg.mms.repository.TheaterRepository;

@Repository
public class TheaterDao {

	@Autowired
	TheaterRepository theTheaterRepository;
	
	public Theater save(Theater t) {
		return theTheaterRepository.save(t);
	}
 
	public List<Theater> getTheater(){
		return theTheaterRepository.findAll();
	}
	
	public Theater findOne(long ID){
		return theTheaterRepository.getOne(ID);
		
	}

	public String deleteTheater(Theater t) {
		theTheaterRepository.deleteById(t.getTheaterId());
		return "Theater Deleted";
	}

	public List<Theater> getTheaterByCityId(City c){
		return theTheaterRepository.findByCity(c);
	}

	public Optional<Theater> findById(long id) {
		return theTheaterRepository.findById(id);

}
}