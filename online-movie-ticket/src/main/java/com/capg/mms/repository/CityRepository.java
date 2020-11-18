package com.capg.mms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.mms.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}