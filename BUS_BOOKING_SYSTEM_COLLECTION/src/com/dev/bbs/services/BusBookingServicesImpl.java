package com.dev.bbs.services;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dev.bbs.beans.Availability;
import com.dev.bbs.beans.Bus;
import com.dev.bbs.beans.Feedback;
import com.dev.bbs.beans.Ticket;
import com.dev.bbs.beans.User;
import com.dev.bbs.dao.BusBookingDAO;
import com.dev.bbs.dao.BusBookingDAOImpl;
import com.dev.exception.LoginFailedException;

public class BusBookingServicesImpl implements BusBookingServices{
	BusBookingDAO db = new  BusBookingDAOImpl();
	static int key=36;
	@Override
	public Boolean createUser(User user) {

		return db.createUser(user);
	}

	@Override
	public Boolean updateUser(User user) {
		return db.updateUser(user);
	}

	@Override
	public User searchUser(int user_id) {
		return db.searchUser(user_id);
	}

	@Override
	public Boolean deleteUser(int user_id) {
		return db.deleteUser(user_id);
	}

	@Override
	public Boolean loginUser(int user_id, String password) {
		return db.loginUser(user_id, password);
	}

	@Override
	public Boolean createBus(Bus bus) {
		return db.createBus(bus);
	}

	@Override
	public Boolean updateBus(Bus bus) {
		return db.updateBus(bus);
	}

	@Override
	public Bus searchBus(int bus_id) {
		return db.searchBus(bus_id);
	}

	@Override
	public Boolean deleteBus(int bus_id) {
		return db.deleteBus(bus_id);
	}

	@Override
	public Boolean adminLogin(int admin_id, String password) {
		return db.adminLogin(admin_id, password);
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		return db.writeFeedback(feed);
	}

	@Override
	public List<Feedback> viewFeedback() {
		// TODO Auto-generated method stub
		return db.viewFeedback();
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		return db.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(int booking_id, int user_id) {
		return db.cancelTicket(booking_id, user_id);
	}

	@Override
	public Ticket getTicket(int booking_id) {
		// TODO Auto-generated method stub
		return db.getTicket(booking_id);
	}

	@Override
	public List<Integer> getAllTicket(int userId) {
		// TODO Auto-generated method stub
		return db.getAllTicket(userId);
	}

	@Override
	public List<Availability> checkAvailability(String source, String destination, Date date) {

		return db.checkAvailability(source, destination, date);
	}

	@Override
	public Integer checkAvailability(int bus_id, Date date) {
		return db.checkAvailability(bus_id, date);
	}

	@Override
	public List<Ticket> getTicketByBus(int busId, Date date) {
		// TODO Auto-generated method stub
		return db.getTicketByBus(busId, date);
	}

	@Override
	public Boolean setBusAvailability(Availability availability) {
		// TODO Auto-generated method stub
		return db.setBusAvailability(availability);
	}

	@Override
	public int getUniqueKey() {
		return key++;
	}

	@Override
	public Integer validateId(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if(mat.matches()){
			return Integer.parseInt(id);
		}else{

			return null;}
	}
	@Override
	public String validateEmail(String email) {
		Pattern	pat = Pattern.compile("\\w+.\\w\\@\\w+\\.\\w+"); 
		Matcher	mat = pat.matcher(email);
		if(mat.matches()){
			return email;
		}else{
			return null;
		}

	}

	@Override
	public Long validateContact(String contact) {
		Pattern	pat = Pattern.compile("\\d{10,10}"); 
		Matcher	mat = pat.matcher(contact);
		if(mat.matches()) {
			return Long.parseLong(contact);
		}else {

			return null;
		}
	}
}