package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Response;
import com.project.dto.TicketDTO;
import com.project.dto.TicketOutDTO;
import com.project.service.TicketService;

@CrossOrigin(origins = "*")
@RestController
public class TicketGenerateController {

	@Autowired
	private TicketService ticketService;
	
//	@RequestMapping("/after/pay")
	public ResponseEntity<?> generateTicketAndInsertBookingInfo(@RequestBody TicketDTO t)
	{
		System.out.println("before Controller");
		TicketOutDTO tOut=ticketService.generateTicket(t);
		System.out.println("after Controller");
		if(tOut==null)
		{
			return Response.error("user not found");
		}
		return Response.success(tOut);
	}
}
