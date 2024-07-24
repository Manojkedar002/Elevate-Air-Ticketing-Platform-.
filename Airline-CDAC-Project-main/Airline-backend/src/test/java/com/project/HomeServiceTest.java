package com.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.dao.PriceDao;
import com.project.dao.RouteDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dao.UserDao;
import com.project.dto.SearchFlight;
import com.project.dto.SearchFlightDto;
import com.project.dto.UserDto;
import com.project.entities.Price;
import com.project.entities.Route;
import com.project.entities.ScheduleFlight;

@SpringBootTest
public class HomeServiceTest 
{
	@Autowired
	private PriceDao priceDao;
	@Autowired
	private ScheduleFlightDao shedFlightDao;
	
    @Test
	public List<SearchFlightDto> searchFlight(SearchFlight serchInfo) {
    	serchInfo.setSource("pune");
    	serchInfo.setDestination("mumbai");
    	serchInfo.setDate("2022-04-05");
    	serchInfo.setClassType("first");
    	serchInfo.setNoOfSeat(2);
		String s1=serchInfo.getDate();
		double  businessClassPrice;
	    double  economyClassPrice;
	    double  firstClassPrice;
	    List<SearchFlightDto> flights = null;
		List<ScheduleFlight> flightOpt = null;
		
		try {
			flightOpt = shedFlightDao.findByTakeoffDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	
		//ScheduleFlight sf= flightOpt.orElse(null);
		for (ScheduleFlight sf : flightOpt) 
		{ 
			if(serchInfo.getSource().equals(sf.getRouteSchedule().getSource()))
			{
				if(serchInfo.getDestination().equals(sf.getRouteSchedule().getDestination()))
				{
					if(serchInfo.getClassType().equals("economyClassSeats"))
					{
					//Flight	flight=flightDao.findByEconomyClass(serchInfo.getClassType())
//						List<Price> flightPrice=priceDao.findByRouteId(sf.getRouteSchedule().getRouteId());
//						for (Price pr : flightPrice) 
//						{ 
//							if(pr.getFlight().getFlightId()==sf.getFlightshedule().getFlightId());
//							{
//								 businessClassPrice=pr.getBusinessClassPrice();
//							     economyClassPrice=pr.getEconomyClassPrice();
//							     firstClassPrice=pr.getFirstClassPrice();
//							}
							
							SearchFlightDto serchFlightDto=new SearchFlightDto();
							serchFlightDto.setSource(sf.getRouteSchedule().getSource());
							serchFlightDto.setDestination(sf.getRouteSchedule().getDestination());
//							serchFlightDto.setTakeoffDate(sf.getTakeoffDate());
//							serchFlightDto.setTakeoffDate(sf.getLandingDate());
							serchFlightDto.setCompanyName(sf.getFlightschedule().getCompanyName());
//							if(serchInfo.getClassType().equals("economy"))
//							    serchFlightDto.setPrice(economyClassPrice);
//							if(serchInfo.getClassType().equals("business"))
//							    serchFlightDto.setPrice(businessClassPrice);
//							if(serchInfo.getClassType().equals("first"))
//							    serchFlightDto.setPrice(firstClassPrice);
						
							flights.add(serchFlightDto);
						}
					}
					
				}
			
			

			System.out.println("before");
			
			System.out.println("Scheudle Id ="+sf.getScheduleId()) ;
			System.out.println("Starting ="+sf.getRouteSchedule().getSource()) ;
			System.out.println("Ending  =" + sf.getRouteSchedule().getDestination());
			System.out.println("take off Date ="+sf.getTakeoffDate());
			System.out.println("take off time ="+sf.getTakeoffTime());
			System.out.println("landing Date ="+sf.getLandingDate());
			
			System.out.println("landing time ="+sf.getLandingTime());
			System.out.println("search info ="+sf.getAvailable_businessClass_seat());
			System.out.println("company name ="+sf.getFlightschedule().getCompanyName());
			System.out.println("Starting ="+sf.getRouteSchedule().getPriceList()) ;
			System.out.println("after");
		
		}
		return null;
	
	}

//	@Autowired
//	private ScheduleFlightDao sheduleDao;
//	
//	@Transactional
//    @Test
//	public void searchFlight() {
//		System.out.println("search info =");
//		Optional<ScheduleFlight> flightOpt=sheduleDao.findById(1);
//		//Optional<SerchFlightDto> flightOpt=sheduleDao.findByTakeoffDate("2022-04-05");
//		ScheduleFlight sf= flightOpt.orElse(null);
//		System.out.println("before");
//		//flightOpt.forEach(System.out.println);
////		System.out.println("search info ="+sf.getSource());
////		System.out.println("search info ="+sf.getDestination());
////		System.out.println("search info ="+sf.getLandingDate());
////		System.out.println("starting ="+sf.getTakeoffDate());
////		System.out.println("after");
//		System.out.println("search info ="+sf.getTakeoffDate());
//		System.out.println("search info ="+sf.getLandingDate());
//		System.out.println("search info ="+sf.getAvailable_businessClass_seat());
//		System.out.println("starting ="+sf.getRouteSchedule().getSource() + " ending" + sf.getRouteSchedule().getDestination());
//		System.out.println("after");
//	
//	}
//	
	@SuppressWarnings("null")
	@Transactional
    @Test
	public void searchFlightByDate() {
		System.out.println("serch info =");
	//Optional<ScheduleFlight> flightOpt=sheduleDao.findById(1);
		ArrayList<Price> al1=new ArrayList<Price>();
		List<ScheduleFlight> flightOpt = null;
		List<Price> price =null;
		try {
			flightOpt = shedFlightDao.findByTakeoffDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-04-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//ScheduleFlight sf= flightOpt.orElse(null);
		for (ScheduleFlight sf : flightOpt) 
		{ 
			//if()

			System.out.println("before");
			//flightOpt.forEach(System.out.println);
//			System.out.println("search info ="+sf.getSource());
//			System.out.println("search info ="+sf.getDestination());
//			System.out.println("search info ="+sf.getLandingDate());
//			System.out.println("starting ="+sf.getTakeoffDate());
//			System.out.println("after");
			System.out.println("Scheudle Id ="+sf.getScheduleId()) ;
			System.out.println("Sarting ="+sf.getRouteSchedule().getSource()) ;
			System.out.println("Ending  =" + sf.getRouteSchedule().getDestination());
			System.out.println("take off Date ="+sf.getTakeoffDate());
			System.out.println("take off time ="+sf.getTakeoffTime());
			System.out.println("landing Date ="+sf.getLandingDate());
			
			System.out.println("landing time ="+sf.getLandingTime());
			System.out.println("serch info ="+sf.getAvailable_businessClass_seat());
			System.out.println("company name ="+sf.getFlightschedule().getCompanyName());
			//List<Price> price =null;
			al1.add((Price) sf.getRouteSchedule().getPriceList());
			System.out.println("aftre");
			for (Price p : al1) 
			{ 
			    System.out.println(p.getFirstClassPrice());
			    System.out.println(p.getBusinessClassPrice());
			    System.out.println(p.getEconomyClassPrice());
//			}
		}
	
	}

}
}
