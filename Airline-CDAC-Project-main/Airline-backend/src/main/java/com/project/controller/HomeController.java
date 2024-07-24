package com.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.Response;
import com.project.dto.SearchFlight;
import com.project.dto.SearchFlightDto;
import com.project.service.HomeService;
import com.project.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HomeService homeService;
	
	@PostMapping("/searchFlight")
	public ResponseEntity<?> searchFlight(@RequestBody SearchFlight searchInfo )
	{
		System.out.println("before Controller");
		List<SearchFlightDto> userDto=homeService.searchFlight(searchInfo);
		System.out.println("after Controller");
		if(userDto==null)
		{
			return Response.error("user not found");
		}
		return Response.success(userDto);
	}
}
