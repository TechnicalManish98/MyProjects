package com.dev.bbs.dao;

import java.util.Date;
import java.util.List;

import com.dev.bbs.beans.Availability;
import com.dev.bbs.beans.Bus;
import com.dev.bbs.beans.Feedback;
import com.dev.bbs.beans.Ticket;
import com.dev.bbs.beans.User;

public interface BusBookingDAO {
	public Boolean createUser(User user);
	public Boolean updateUser(User user);
	public User searchUser(int user_id);
	public Boolean deleteUser(int user_id);
	public Boolean loginUser(int user_id, String password);
	
	//manipulating bus
	public Boolean createBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Bus searchBus(int bus_id);
	public Boolean deleteBus(int bus_id);
	
	//admin
	public Boolean adminLogin(int admin_id,String password);
	
	// Feedback
		public Boolean writeFeedback(Feedback feed);
		public List<Feedback> viewFeedback();
	
	//ticket Booking
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(int booking_id, int user_id);
	public Ticket getTicket(int booking_id);
	public List<Integer> getAllTicket(int userId);
	public List<Availability> checkAvailability(String source, String destination, Date date);
	public Integer checkAvailability(int bus_id,Date date);
	
	public List<Ticket> getTicketByBus(int busId,Date date);

	public Boolean setBusAvailability(Availability availability);

}
