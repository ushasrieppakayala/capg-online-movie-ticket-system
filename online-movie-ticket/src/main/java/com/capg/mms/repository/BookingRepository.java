package com.capg.mms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.Bookings;
import com.capg.mms.entity.Show;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long>{

	public List<Bookings> findByShow(Show show);
}