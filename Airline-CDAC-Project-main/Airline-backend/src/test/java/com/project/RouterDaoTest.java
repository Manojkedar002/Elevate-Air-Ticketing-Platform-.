package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.dao.RouteDao;
import com.project.entities.Price;
import com.project.entities.Route;
import com.project.entities.ScheduleFlight;

@SpringBootTest
public class RouterDaoTest {

	@Autowired
	private RouteDao routeDao;
	
	@Transactional
    @Test
	public void searchFlight() {
		System.out.println("serch info =");
		Optional<Route> flightOpt=routeDao.findById(10);
		//Optional<Route> flightOpt=routeDao.;
	    Route flight =flightOpt.orElse(null);
		System.out.println("before");
		//flightOpt.forEach(System.out::println);
		System.out.println("serch info ="+flight.getRouteId());
		System.out.println("serch info ="+flight.getSource());
		System.out.println("serch info ="+flight.getDestination());
		
//		ArrayList<Price> priceRoute =new ArrayList<Price>();
//		priceRoute.add((Price) flight.getPriceList());
		
		for(Price rp : flight.getPriceList())
		{
			System.out.println("serch info ="+rp.getEconomyClassPrice());
			System.out.println("serch info ="+rp.getBusinessClassPrice());
			
		}
		//System.out.println(flight.toString());
	
	}
}
