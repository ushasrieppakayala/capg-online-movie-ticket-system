package com.capg.mms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.mms.dao.BookingDao;
import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Show;
import com.capg.mms.exceptions.BookingNotFound;

@Service
public class BookingServiceImpl implements IBookingsService{

	@Autowired
	BookingDao bookingDao;
	
	@Override
	public List<Bookings> getBookingByShowId(Show show) {
		return bookingDao.addBookingByShowId(show);
	}

	@Override
	public Bookings saveBooking(Bookings b) {
		
		return bookingDao.saveBook(b);
	}

	@Override
	public Bookings findOne(long ID) {
		
		return bookingDao.findOne(ID);
	}

	@Override
	public String deleteBooking(Bookings b) {
		Optional<Bookings> bh= bookingDao.findById(b.getBookingId());
		 if(!bh.isPresent())
		 {
			 throw new BookingNotFound("Booking not found");
			 
		 }
		return bookingDao.deleteBooking(b);
	}

	@Override
	public List<Bookings> getBooking() {
	
		return bookingDao.getBooking();
	}
	
}

