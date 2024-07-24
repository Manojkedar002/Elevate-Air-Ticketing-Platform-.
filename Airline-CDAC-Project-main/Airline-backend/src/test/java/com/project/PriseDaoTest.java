//package com.project;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.transaction.Transactional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.project.dao.PriceDao;
//import com.project.dto.SearchFlight;
//import com.project.dto.SerchFlightDto;
//import com.project.entities.Price;
//
//@SpringBootTest
//public class PriseDaoTest {
//	@Autowired
//	private PriceDao priceDao;
//	
//	@Transactional
//    @Test
//	public void findPriceObj() 
//	{
//   // List<Price> price=priceDao.findByRoute(10);+
//	//	List<Price> price=priceDao.findByRouteId(10);		
//// Optional<Price> prices=priceDao.findById(1);
//		Optional<Price> price=priceDao.findByFlight(101);
//     	  Price prices=price.orElse(null);
//     	 System.out.println(prices.getFirstClassPrice());
////    for (Price pr : price) 
////	{ 
////		
////    System.out.println(pr.getFirstClassPrice());
////		
////	}
//	
//}
//}
