package com.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Optional;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PriceDao;
import com.project.dao.RouteDao;
import com.project.dao.ScheduleFlightDao;
//import com.project.dao.FlightDao;
//import com.project.dao.UserDao;
import com.project.dto.SearchFlight;
import com.project.entities.Price;
import com.project.entities.ScheduleFlight;
//import com.project.entities.Flight;
//import com.project.entities.Route;
import com.project.dto.SearchFlightDto;
//import com.project.dto.UserDto;

@Transactional
@Service
public class HomeService 
{
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private ScheduleFlightDao shedFlightDao;
	@Autowired
	private PriceDao priceDao;

	//@SuppressWarnings({ "unused" })
	public List<SearchFlightDto> searchFlight(SearchFlight searchInfo) {
		String s1=searchInfo.getDate();
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss");
		Date d1=null;
		try {
			d1 = sdf.parse(s1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    ArrayList<SearchFlightDto> al=new ArrayList<SearchFlightDto>();
	    List<SearchFlightDto> flights = null;
		List<ScheduleFlight> flightOpt = null;

	    System.out.println("before Dao");
		flightOpt = shedFlightDao.findByTakeoffDate(d1);
		if(flightOpt ==null) {
			return null;
		}
		else {
		//ScheduleFlight sf= flightOpt.orElse(null);
		for (ScheduleFlight sf : flightOpt) 
		{  
			System.out.println("in for loop");
			if(sf.getRouteSchedule().getSource().equals(searchInfo.getSource())) //source compare
			{
				System.out.println("in source");
				if(sf.getRouteSchedule().getDestination().equals(searchInfo.getDestination()))//destination compare
				{
					System.out.println("in destination");
						System.out.println("class");
						SearchFlightDto searchFlightDto =new SearchFlightDto();
						searchFlightDto.setSheduleId(sf.getScheduleId());
						searchFlightDto.setSource(sf.getRouteSchedule().getSource());
						searchFlightDto.setDestination(sf.getRouteSchedule().getDestination());
						String d3 =sdf.format(sf.getTakeoffDate());
						searchFlightDto.setTakeoffDate(d3);
						String d4 =sdf.format(sf.getLandingDate());
						searchFlightDto.setLandingDate(d4);
						String t1 =sdf1.format(sf.getTakeoffTime());
						searchFlightDto.setTakeoffTime(t1);
						String t2 =sdf1.format(sf.getLandingTime());
						searchFlightDto.setLandingTime(t2);
						searchFlightDto.setCompanyName(sf.getFlightschedule().getCompanyName());
						System.out.println("after setter");

					//===================================================================================
						//set price   and available seat
					//==============================================================================
//						Optional<Route> routePrice=routeDao.findById(sf.getRouteSchedule().getRouteId());
//						Route flight =routePrice.orElse(null);
						List<Price> allPrice =priceDao.findAll();
						for(Price rp : allPrice)
						{
							if(sf.getFlightschedule().getFlightId() == rp.getFlight().getFlightId())
							{
								if(sf.getRouteSchedule().getRouteId() == rp.getRoute().getRouteId())
								{
									System.out.println("aaaaaaa");
						    	   if(searchInfo.getClassType().equals("economy")) 
						 	       {
						 		      searchFlightDto.setPrice(rp.getEconomyClassPrice());
							          searchFlightDto.setAvailable_Seat(sf.getAvailable_economyClass_seat());				    
							       }
						    	  if(searchInfo.getClassType().equals("business"))
							      {
							          searchFlightDto.setPrice(rp.getBusinessClassPrice());
						        	  searchFlightDto.setAvailable_Seat(sf.getAvailable_businessClass_seat());
						          }
						     	  if(searchInfo.getClassType().equals("first"))
						      	  {
						     		searchFlightDto.setPrice(rp.getFirstClassPrice());
						     		searchFlightDto.setAvailable_Seat(sf.getAvailable_firstClass_seat());
						    	  }
								}
							}
						}
					//==============================================================================	
						if(searchFlightDto !=null)
							  al.add(searchFlightDto);                 //adding sea rched flight in list
						System.out.println("after add");
					
				   }
			    }				
		   }
		}
	
		return al;
	}
}
