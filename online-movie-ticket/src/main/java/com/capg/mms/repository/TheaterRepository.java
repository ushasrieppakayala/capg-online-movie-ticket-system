package com.capg.mms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.City;
import com.capg.mms.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByCity(City c);
}