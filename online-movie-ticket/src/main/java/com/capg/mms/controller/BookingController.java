package com.capg.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Show;
import com.capg.mms.service.BookingServiceImpl;
import com.capg.mms.service.ShowServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;
	
	@Autowired
	ShowServiceImpl showService;
	
	@PostMapping("/addbooking/{show}")
	public Bookings createBooking(@PathVariable(value="show") long showId, @RequestBody Bookings requestData) {	
	Bookings theBook = new Bookings();
		theBook.setSeat(requestData.getSeat());
		//Show theShow = showService.fetchById(showId);
		//theBook.setShow(theShow);
		return bookingService.saveBooking(theBook);
	}
	
	@DeleteMapping("/deleteBooking/{ID}")
	public ResponseEntity<Bookings> deleteBooking(@PathVariable(value = "ID") long ID){
		Bookings theBook = bookingService.findOne(ID);
		if(theBook == null) {
			return ResponseEntity.notFound().build();
		}
		bookingService.deleteBooking(theBook);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/updateBooking/{ID}")
	public ResponseEntity<Bookings> updateBooking(@PathVariable(value = "ID" ) long ID,  @RequestBody Bookings b){
		Bookings theBook = bookingService.findOne(ID);
		if(theBook == null) {
			return ResponseEntity.notFound().build();
		}
		theBook.setSeat(b.getSeat());
		Bookings updateBook = bookingService.saveBooking(theBook);
		return ResponseEntity.ok().body(updateBook);
		
	}
	
	@GetMapping("/allBooking")
	public List<Bookings> getBooking(){
		return bookingService.getBooking();
	}
	
	
	@GetMapping("/Booking/{ID}")
	public ResponseEntity<Bookings> getOneBooking(@PathVariable(value = "ID") long ID){
		Bookings theBook = bookingService.findOne(ID);
		if(theBook == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theBook);
	}
	
	
	//@GetMapping("/{ID}/Booking")
	//public List<Bookings> getBookingListInShow(@PathVariable(value = "ID") long ID){
		
		//Show theShow = showService.fetchById(ID);
		//return bookingService.getBookingByShowId(theShow);
		
	//}

}
