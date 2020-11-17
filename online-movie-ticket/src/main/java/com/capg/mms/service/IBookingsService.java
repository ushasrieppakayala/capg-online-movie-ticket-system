package com.capg.mms.service;

import java.util.List;

import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Show;

public interface IBookingsService {

	public List<Bookings> getBookingByShowId(Show show);
	public Bookings saveBooking(Bookings b);
	public Bookings findOne(long ID);
	public String deleteBooking(Bookings b);
	public List<Bookings> getBooking();


}
