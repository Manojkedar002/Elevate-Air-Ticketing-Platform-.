package com.project.dto;

//import java.sql.Timestamp;
//import java.util.Date;

public class SearchFlightDto 
{
	private int scheduleId;
	private String source;
	private String destination;
	private String takeoffDate;
	private String landingDate;
	private String CompanyName;
	private String landingTime;
	private String takeoffTime;
	private double price;
	private int available_Seat;
//	private int available_Business_seat;
//	private int available_first_seat;
	
	public SearchFlightDto() {
		
	}
	public SearchFlightDto(int scheduleId, String source, String destination, String takeoffDate, String landingDate,
		String companyName, String landingTime, String takeoffTime, double price, int available_Seat) {
	super();
	this.scheduleId = scheduleId;
	this.source = source;
	this.destination = destination;
	this.takeoffDate = takeoffDate;
	this.landingDate = landingDate;
	this.CompanyName = companyName;
	this.landingTime = landingTime;
	this.takeoffTime = takeoffTime;
	this.price = price;
	this.available_Seat = available_Seat;
}
	public SearchFlightDto(int scheduleId, String source, String destination, String takeoffDate, String landingDate,
			String companyName, String landingTime, String takeoffTime, double price) 
	{
		super();
		this.scheduleId = scheduleId;
		this.source = source;
		this.destination = destination;
		this.takeoffDate = takeoffDate;
		this.landingDate = landingDate;
		this.CompanyName = companyName;
		this.landingTime = landingTime;
		this.takeoffTime = takeoffTime;
		this.price = price;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setSheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTakeoffDate() {
		return takeoffDate;
	}
	public void setTakeoffDate(String takeoffDate) {
		this.takeoffDate = takeoffDate;
	}
	public String getLandingDate() {
		return landingDate;
	}
	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		this.CompanyName = companyName;
	}
	public String getLandingTime() {
		return landingTime;
	}
	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}
	public String getTakeoffTime() {
		return takeoffTime;
	}
	public void setTakeoffTime(String takeoffTime) {
		this.takeoffTime = takeoffTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailable_Seat() {
		return available_Seat;
	}
	public void setAvailable_Seat(int available_Seat) {
		this.available_Seat = available_Seat;
	}
	
	@Override
	public String toString() {
		return "SearchFlightDto [ScheduleId=" + scheduleId + ", source=" + source + ", destination=" + destination
				+ ", takeoffDate=" + takeoffDate + ", landingDate=" + landingDate + ", CompanyName=" + CompanyName
				+ ", landingTime=" + landingTime + ", takeoffTime=" + takeoffTime + ", price=" + price
				+ ", available_Seat=" + available_Seat + "]";
	}	
}
