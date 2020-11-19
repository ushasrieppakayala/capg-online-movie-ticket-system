package com.capg.mms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capg.mms.dao.TheaterDao;
import com.capg.mms.entity.Theater;
import com.capg.mms.service.ITheaterService;

@SpringBootTest
public class TheaterTest {


	@Autowired
	private ITheaterService theaterService ;
	
	@MockBean
	private TheaterDao theaterDao ;
	
    RestTemplate restTemp ;
		
	@BeforeEach
	public void setup()
	{
			restTemp = new RestTemplate() ;
	}
		
	@Test
	public void testAddTheater() 
	{
		Theater theater = new Theater("tname", "tarea") ;
			
		ResponseEntity<Theater> theaterResp = restTemp.postForEntity("http://localhost:9090/theater/addTheater", theater, Theater.class) ;
			
		assertEquals(200 , theaterResp.getStatusCodeValue());		
		
	}
		
	@Test
	public void testAllMovie()
	{
			
		ResponseEntity<Theater> theaterResp = restTemp.getForEntity("http://localhost:9090/theater/alltheaters", Theater.class) ;
			
			assertEquals(200, theaterResp.getStatusCodeValue());
	}
}
