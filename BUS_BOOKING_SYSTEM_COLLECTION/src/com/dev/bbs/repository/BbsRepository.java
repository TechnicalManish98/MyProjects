package com.dev.bbs.repository;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.dev.bbs.beans.Admin;
import com.dev.bbs.beans.Availability;
import com.dev.bbs.beans.Bus;
import com.dev.bbs.beans.Feedback;
import com.dev.bbs.beans.Ticket;
import com.dev.bbs.beans.User;
public class BbsRepository 
{
	public static HashMap<Integer,User> users_info = new HashMap<Integer,User>();
    public static HashMap<Integer,Bus> bus_info = new HashMap<Integer,Bus>();
	public static HashMap<Integer,Admin> admin_info = new HashMap<Integer,Admin>();
	public static HashMap<Integer,Ticket> booking_info=new HashMap<>();
	public static HashMap<Integer,Availability> availability_info = new HashMap<Integer,Availability>();
	public static HashMap<Integer,Feedback> suggestion_info = new HashMap<Integer,Feedback>();

	public BbsRepository() {
		User user = new User();
		User user1 = new User();

		user.setUser_id(1);
		user.setUsername("manish");
		user.setEmail("manish@gmail.com");
		user.setContact(9967785459l);
		user.setPassword("manish123");

		user1.setUser_id(2);
		user1.setUsername("Lande");
		user1.setEmail("Lande@gmail.com");
		user1.setContact(9967785463l);
		user1.setPassword("lande123");
		users_info.put(user.getUser_id(),user);
		users_info.put(user1.getUser_id(), user1);

		Bus bus = new Bus();
		Bus bus1 = new Bus();


		bus.setBus_id(401);
		bus.setBusname("Mumbai-pune Bus");
		bus.setBus_type("AC");
		bus.setSource("Mumbai");
		bus.setDestination("Pune");
		bus.setTotal_seats(60);
		bus.setPrice(500);

		bus1.setBus_id(402);
		bus1.setBusname("Mumbai-banglore Bus");
		bus1.setBus_type("AC");
		bus1.setSource("Mumbai");
		bus1.setDestination("Banglore");
		bus1.setTotal_seats(60);
		bus1.setPrice(1200);

		bus_info.put(bus.getBus_id(), bus);
		bus_info.put(bus1.getBus_id(), bus1);

		Admin admin = new Admin();
		admin.setAdmin_id(1);
		admin.setAdmin_name("manish lande");
		admin.setContact(7797654593l);
		admin.setEmail("admin@gmail.com");
		admin.setPassword("admin123");

		admin_info.put(admin.getAdmin_id(), admin);

		
		//ticket
		
		Ticket ticket = new Ticket();	
		ticket.setBooking_id(101);
		ticket.setUser_id(1);
		ticket.setBus_id(401);
		ticket.setNumofseats(60);
		String tempDate="2019-09-21";
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
		Date date = null;
		try {
			date = sdf.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ticket.setJourney_date(date);

		Date datetime= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		ticket.setBooking_datetime(ts);

		booking_info.put(ticket.getBooking_id(),ticket);
		
		
//Availability
		
		Availability availability = new Availability();
		availability.setAvailId(1);
		String tempDate1="2019-09-21";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = sdf1.parse(tempDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		availability.setAvailDate(date1);
		availability.setAvailSeats(10);
		availability.setBusId(401);
		availability_info.put(availability.getAvailId(),availability);
		
		
		Feedback feedback = new Feedback();
		String feedbak ="Good Service provided";
		feedback.setFeedback(feedbak);
		feedback.setSuggId(1);
		feedback.setUserId(1);
		suggestion_info.put(feedback.getSuggId(),feedback);
		
		


	}
}
