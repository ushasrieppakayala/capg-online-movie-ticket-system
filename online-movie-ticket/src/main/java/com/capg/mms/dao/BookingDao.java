package com.capg.mms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Show;
import com.capg.mms.repository.BookingRepository;

@Repository
public class BookingDao {
	
	@Autowired
	BookingRepository bookingRepository;
	
	public List<Bookings> addBookingByShowId(Show show){
		return bookingRepository.findByShow(show);
	}
	
	public Bookings saveBook(Bookings b) {
		return bookingRepository.save(b);
	}
	
	public Bookings findOne(long ID){
		
		return bookingRepository.getOne(ID);
	}
	
	public String deleteBooking(Bookings b) {
		bookingRepository.deleteById(b.getBookingId());
		return "Booking Deleted";
	}
	
	public Optional<Bookings> findById(long id) {
		return bookingRepository.findById(id);	
	}
	
	public List<Bookings> getBooking(){
		return bookingRepository.findAll();
	}
}

