package com.capg.mms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capg.mms.dao.CityDao;
import com.capg.mms.entity.City;
import com.capg.mms.service.ICityService;


@SpringBootTest
public class CityTest {


	@Autowired
	private ICityService cityService ;
	
	@MockBean
	private CityDao cityDao ;
	
    RestTemplate restTemp ;
		
	@BeforeEach
	public void setup()
	{
			restTemp = new RestTemplate() ;
	}
		
	@Test
	public void testAddCity() 
	{
		City city = new City("cname", "cpincode", "cstate") ;
			
		ResponseEntity<City> cityResp = restTemp.postForEntity("http://localhost:9090/city/addCity", city, City.class) ;
			
		assertEquals(200 ,cityResp.getStatusCodeValue());		
		
	}
		
	@Test
	public void testAllCity()
	{
			
		ResponseEntity<City> cityResp = restTemp.getForEntity("http://localhost:9090/city/allCity", City.class) ;
			
			assertEquals(200, cityResp.getStatusCodeValue());
	}
}
