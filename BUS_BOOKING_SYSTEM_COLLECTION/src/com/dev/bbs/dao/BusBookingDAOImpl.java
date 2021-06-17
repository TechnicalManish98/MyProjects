package com.dev.bbs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.dev.bbs.beans.Admin;
import com.dev.bbs.beans.Availability;
import com.dev.bbs.beans.Bus;
import com.dev.bbs.beans.Feedback;
import com.dev.bbs.beans.Ticket;
import com.dev.bbs.beans.User;
import com.dev.bbs.repository.BbsRepository;
import com.dev.bbs.services.BusBookingServices;
import com.dev.bbs.services.BusBookingServicesImpl;

public class BusBookingDAOImpl implements BusBookingDAO{

	BbsRepository repo = new BbsRepository();
	HashMap<Integer,User> users_info = repo.users_info;
	HashMap<Integer,Bus> bus_info = repo.bus_info;
	HashMap<Integer,Admin> admin_info = repo.admin_info;
	HashMap<Integer,Ticket> booking_info = repo.booking_info;
	HashMap<Integer,Availability> availability_info = repo.availability_info;
	HashMap<Integer,Feedback> suggestion_info = repo.suggestion_info;

	@Override
	public Boolean createUser(User user) {
		if(!users_info.containsKey(user.getUser_id())) 
		{
			users_info.put(user.getUser_id(),user);
			return true;
		}else {
			return false;
		}

	}
	@Override
	public Boolean updateUser(User user) {
		if(users_info.containsKey(user.getUser_id())) {
			users_info.put(user.getUser_id(), user);
			return true;
		}
		return false;
	}

	@Override
	public User searchUser(int user_id) {
		if(users_info.containsKey(user_id)) {
			return users_info.get(user_id);
		}else {
			return null;
		}
	}

	@Override
	public Boolean deleteUser(int user_id) {
		if(users_info.containsKey(user_id)) {
			users_info.remove(user_id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean loginUser(int user_id, String password) {
		User user = null;
		if(users_info.containsKey(user_id)) {
			user=users_info.get(user_id);
			if(user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean createBus(Bus bus) {
		if(!bus_info.containsKey(bus.getBus_id())) {
			bus_info.put(bus.getBus_id(), bus);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateBus(Bus bus) {
		if(bus_info.containsKey(bus.getBus_id())) {
			bus_info.put(bus.getBus_id(), bus);
			return true;
		}
		return false;
	}

	@Override
	public Bus searchBus(int bus_id) {
		if(bus_info.containsKey(bus_id)) {
			return bus_info.get(bus_id);
		}else
			return null;
	}

	@Override
	public Boolean deleteBus(int bus_id) {
		if(bus_info.containsKey(bus_id)) {
			bus_info.remove(bus_id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean adminLogin(int admin_id, String password) {
		if(admin_info.containsKey(admin_id)) {
			Admin admin = admin_info.get(admin_id);
			if(admin_info.containsKey(password)) {
				return true;
			}return true;
		}
		return false;

	}
	@Override
	public Boolean writeFeedback(Feedback feed) {

		User user = searchUser(feed.getUserId());
		if(user!= null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Feedback> viewFeedback() {
		List<Feedback> feedList = new ArrayList<>();

		for(Integer feedBackId : suggestion_info.keySet()){
			feedList.add(suggestion_info.get(feedBackId));
		}
		System.out.println(feedList);

		return feedList;

	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		Random rand=new Random();
		ticket.setBooking_id(rand.nextInt());
		System.out.println(ticket);

		Ticket bookedTicket=null;


		Availability availability = null;
		int availSeats = checkAvailability(ticket.getBus_id(),ticket.getJourney_date());

		if(ticket.getNumofseats() <= availSeats) {

			// ticket booked
			if(ticket != null) {
				booking_info.put(ticket.getBooking_id(),ticket);
				bookedTicket=ticket;
				//reduced the number of seats from the availability
				for(Integer availId:availability_info.keySet() ){
					availability=availability_info.get(availId);
					if(availability.getBusId()==ticket.getBus_id()
							&& availability.getAvailDate().equals(ticket.getJourney_date())){

						availability.setAvailSeats(availability.getAvailSeats()-ticket.getNumofseats());
						availability_info.put(availability.getAvailId(), availability);

					}
				}

			}
		}


		return bookedTicket;
	}

	@Override
	public Boolean cancelTicket(int booking_id, int user_id) {
		// cancel if already booked and add numb of seats to availability column
		Boolean res=false;
		if(booking_info.containsKey(booking_id)){
			Ticket ticket=booking_info.get(booking_id);
			//cancel the ticket
			booking_info.remove(booking_id);
			res=true;
			//inc avail seats in availabilityInfo
			Availability availability;
			for(Integer availId:availability_info.keySet() ){
				availability=availability_info.get(availId);
				if(availability.getBusId()==ticket.getBus_id() && 
						availability.getAvailDate().equals(ticket.getJourney_date()))
				{
					availability.setAvailSeats(availability.getAvailSeats() + ticket.getNumofseats());
					availability_info.put(availability.getAvailId(), availability);

				}
			}
		}
		return res;		
	}

	@Override
	public Ticket getTicket(int booking_id) {
		Ticket ticket=null;
		if(booking_info.containsKey(booking_id)){
			return booking_info.get(booking_id);
		}else{
			return ticket;
		}
	}

	@Override
	public List<Integer> getAllTicket(int userId) {
		List<Integer> ticketAll = new ArrayList<>();
		for(Integer bookingId : booking_info.keySet()){

			Ticket ticket=booking_info.get(bookingId);
			//	System.out.println(ticket);
			if(ticket.getUser_id()==userId){
				ticketAll.add(bookingId);
			}		

		}


		return ticketAll;
	}

	@Override
	public List<Availability> checkAvailability(String source, String destination, Date date) {
		List<Availability> availList = new ArrayList<Availability>();
		Availability availability = null;
		Bus bus=null;

		for(Integer availId:availability_info.keySet()){
			availability=availability_info.get(availId);
			System.out.println(availability);
			bus=searchBus(availability.getBusId());
			System.out.println(bus);
			if(bus.getSource().equals(source) &&
					bus.getDestination().equals(destination) && 
					availability.getAvailDate().equals(date)){
				availList.add(availability);
			}
		}
		return availList;
	}

	@Override
	public Integer checkAvailability(int bus_id, Date date) {
		int seats = 0;
		for(Integer availId: availability_info.keySet()){
			Availability avail=availability_info.get(availId);
			if(bus_id==avail.getBusId() && date.equals(avail.getAvailDate())){
				seats=avail.getAvailSeats();
			}		
		}
		return seats;
	}

	@Override
	public List<Ticket> getTicketByBus(int busId, Date date) {
		List<Ticket> ticketAl = new ArrayList<>();
		Ticket ticket=null;
		for(Integer bookingId : booking_info.keySet()){
			System.out.println(bookingId);
			ticket=booking_info.get(bookingId);
			if(ticket.getBus_id()==busId && ticket.getJourney_date().equals(date)){
				ticketAl.add(ticket);
			}
		}
		return ticketAl;	
	}

	@Override
	public Boolean setBusAvailability(Availability availability) {
		//get avail id
		System.out.println(availability);
		boolean state=false;
		BusBookingServices service = new BusBookingServicesImpl();
		availability.setAvailId(service.getUniqueKey());
		if(availability!=null){
			availability_info.put(availability.getAvailId(), availability);
			state= true;
		}
		return state;

	}

}
