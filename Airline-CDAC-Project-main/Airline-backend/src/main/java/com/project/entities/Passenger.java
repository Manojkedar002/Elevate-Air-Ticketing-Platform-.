package com.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.sun.istack.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int passengerId;
	@NotNull
	private String passengerName;
	@Temporal(TemporalType.DATE)
	private Date passengerDob;
	private int passengerAadharNo;
	private int passengerPassportNo;
	@NotNull
	private String email;
	@NotNull
	private String phoneNo;
	
	@OneToMany(mappedBy ="passenger")
	List<Bookings> bookings;
	
	public Passenger() {
		super();
	}

	public Passenger(int passengerId, String passengerName, Date passengerDob, int passengerAadharNo,
			int passengerPassportNo, String email, String phoneNo, List<Bookings> bookings) 
	{
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerDob = passengerDob;
		this.passengerAadharNo = passengerAadharNo;
		this.passengerPassportNo = passengerPassportNo;
		this.email = email;
		this.phoneNo = phoneNo;
		this.bookings = bookings;
	}
	
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getPassengerDob() {
		return passengerDob;
	}

	public void setPassengerDob(Date passengerDob) {
		this.passengerDob = passengerDob;
	}

	public int getPassengerAadharNo() {
		return passengerAadharNo;
	}

	public void setPassengerAadharNo(int passengerAadharNo) {
		this.passengerAadharNo = passengerAadharNo;
	}

	public int getPassengerPassportNo() {
		return passengerPassportNo;
	}

	public void setPassengerPassportNo(int passengerPassportNo) {
		this.passengerPassportNo = passengerPassportNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerDob="
				+ passengerDob + ", passengerAadharNo=" + passengerAadharNo + ", passengerPassportNo="
				+ passengerPassportNo + ", email=" + email + ", phoneNo=" + phoneNo + ", bookings=" + bookings + "]"; }

}
