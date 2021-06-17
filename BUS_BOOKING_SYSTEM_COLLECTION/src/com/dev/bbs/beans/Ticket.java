package com.dev.bbs.beans;

import java.sql.Timestamp;
import java.util.Date;

public class Ticket 
{
	private int booking_id;
	private int bus_id;
	private int user_id;
	private Date journey_date;
	private int  numofseats;
	private Timestamp  booking_datetime;
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public java.util.Date getJourney_date() {
		return (java.util.Date) journey_date;
	}
	public void setJourney_date(Date journey_date) {
		this.journey_date = journey_date;
	}
	public int getNumofseats() {
		return numofseats;
	}
	public void setNumofseats(int numofseats) {
		this.numofseats = numofseats;
	}
	public Timestamp getBooking_datetime() {
		return booking_datetime;
	}
	public void setBooking_datetime(Timestamp booking_datetime) {
		this.booking_datetime = booking_datetime;
	}
	@Override
	public String toString() {
		return "Ticket [booking_id=" + booking_id + ", bus_id=" + bus_id + ", user_id=" + user_id + ", journey_date="
				+ journey_date + ", numofseats=" + numofseats + ", booking_datetime=" + booking_datetime + "]";
	}
	
	
	

}
