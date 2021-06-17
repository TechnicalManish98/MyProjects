package com.dev.bbs.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dev.bbs.beans.Admin;
import com.dev.bbs.beans.Availability;
import com.dev.bbs.beans.Bus;
import com.dev.bbs.beans.Feedback;
import com.dev.bbs.beans.Ticket;
import com.dev.bbs.beans.User;
import com.dev.bbs.repository.BbsRepository;
import com.dev.bbs.services.BusBookingServices;
import com.dev.bbs.services.BusBookingServicesImpl;
import com.dev.exception.BookedTicketNotFoundException;
import com.dev.exception.BusCreateException;
import com.dev.exception.BusNotFoundException;
import com.dev.exception.BusTicketBookingFailedException;
import com.dev.exception.BusUpdateException;
import com.dev.exception.CancalTicketException;
import com.dev.exception.DeleteBusException;
import com.dev.exception.DeleteUserException;
import com.dev.exception.FeedbackException;
import com.dev.exception.LoginFailedException;
import com.dev.exception.SetBusAvailabilityException;
import com.dev.exception.UserCreationFailedException;
import com.dev.exception.UserFeedbackException;
import com.dev.exception.UserNotFoundException;
import com.dev.exception.UserUpdationFailedException;

public class BusBookingSystemApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String username;
		String password = null;
//		String contact;
		String busname;
		String source;
		String destination;
		String bus_type;
		int total_seats;
		double price;
		int admin_id;
		BbsRepository repo = new BbsRepository();

		BusBookingServices busbookingservices = new BusBookingServicesImpl();
		User user = new User();
		Bus bus = new Bus();

		System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
		System.out.println("********************************************");
		System.out.println("1] User Login");
		System.out.println("2] Admin Login");
		System.out.println("3] Regiser User");
		System.out.println("*********************************************");

		int selection = sc.nextInt();
		switch (selection) {

		case 1: {
			Boolean validation = true;
			Boolean login=false;
			int user_id=0;
			while(validation) {
				System.out.println("Enter user id");
				String userid = sc.next();
				Integer result = busbookingservices.validateId(userid);
				if(result!=null) {
					user_id = result;
					validation = false;
				}else {
					LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
					loginException.getMessage();
				}
				User tempuser = busbookingservices.searchUser(user_id);
				
				if(tempuser!=null) {
					System.out.println(tempuser);
					
					System.out.println("Enter the password");
					 password = sc.next();
					 if(password.equals(tempuser.getPassword())) {
						 login=true;
					 }else {
						 LoginFailedException loginException = new LoginFailedException("Enter Correct Password..");
							loginException.getMessage();
					 }
				}
			login = busbookingservices.loginUser(user_id, password);
				if(login) {
					System.out.println("user Login successful");
					System.out.println("****************************************");
				}else {
					LoginFailedException loginException = new LoginFailedException("Login Failed ! Enter valid details");
					loginException.getMessage();
				}
			}	
				Boolean b = true;
				while (b) {

					System.out.println("BUS RESERVATION AND TICKETING SYSTEM ");
					System.out.println("******************************************");
					System.out.println("1] Update User Information");
					System.out.println("2] Delete Account");
					System.out.println("3] Search User Details");
					System.out.println("4] Book Bus Ticket");
					System.out.println("5] View Bus Ticket");
					System.out.println("6] Cancle Bus Ticket");
					System.out.println("7] write feedback");

					System.out.println("******************************************");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						Boolean Validation = true;
						int user_id1=0;
						while(Validation) {
							System.out.println("Enter user id");
							String userid = sc.next();
							Integer result = busbookingservices.validateId(userid);
							if(result!=null) {
								user_id1 = result;
								validation = false;
								break;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();
							}
						}
						System.out.println("Enter the password");
						password = sc.next();

						System.out.println("Enter username");
						username = sc.next();
						String email = null;
						Boolean Validate = true;
						while(Validate) {
							System.out.println("Enter the email id");
							 email = sc.next();
							String result = busbookingservices.validateEmail(email);
							if(result!=null) {
								email = result;
								Validate = false;
							}else {
								LoginFailedException loginFailedException = new LoginFailedException("Enter Valid Email-Id");
								loginFailedException.getMessage();
							}

						}
//						
						Boolean validate = true;
						Long contacts=null;
						while(validate) {
							System.out.println("Enter contact");
							String contact = sc.next();
							Long result = busbookingservices.validateContact(contact);
							if(result!=null) {
								contacts = result;
								validate = false;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter Valid Contact no.");
								loginException.getMessage();
								
							}
							
							
						}

						user.setUser_id(user_id1);
						user.setUsername(username);
						user.setEmail(email);
						user.setPassword(password);
						user.setContact(contacts);

						if (busbookingservices.updateUser(user)) {
							System.out.println("User Data updated");
							System.out.println("--------------------------------------------------------------");

						} else {
							UserUpdationFailedException userUpdationFailedException = new UserUpdationFailedException("Updation Failed...");
							userUpdationFailedException.getMessage();
						}

					}
					
					break;
					case 2:{
						Boolean Validation = true;
						int user_id1=0;
						while(Validation) {
							System.out.println("Enter user id");
							String userid = sc.next();
							Integer result = busbookingservices.validateId(userid);
							if(result!=null) {
								user_id1 = result;
								validation = false;
								break;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();
							}
						}

						Boolean result = busbookingservices.deleteUser(user_id1);
						if (result) {
							System.out.println("User Data Deleted");
							System.out.println("--------------------------------------------------------------");

						} else {
							throw new DeleteUserException("User not delete ! please enter correct user id");
						}
					}
					break;
					case 3:{
						Boolean Validation = true;
						int user_id1=0;
						while(Validation) {
							System.out.println("Enter user id");
							String userid = sc.next();
							Integer result = busbookingservices.validateId(userid);
							if(result!=null) {
								user_id1 = result;
								validation = false;
								break;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();
							}
						}
						User tempuser = busbookingservices.searchUser(user_id1);

						if (tempuser != null) {
							System.out.println(tempuser);
							System.out.println("--------------------------------------------------------------");

						} else {
							LoginFailedException loginFailedexception = new LoginFailedException("User not found..");
							loginFailedexception.getMessage();
						}
					}
					break;
					case 4:{
						Ticket ticket = new Ticket();
						Boolean Validation = true;
						int user_id1=0;
						while(Validation) {
							System.out.println("Enter user id");
							String userid = sc.next();
							Integer result = busbookingservices.validateId(userid);
							if(result!=null) {
								user_id1 = result;
								validation = false;
								break;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();
							}
						}
						System.out.println("Enter source point");
						String Source = sc.next();
						System.out.println("Enter Destination point");
						String Destination = sc.next();

						System.out.println("Enter date of journey(yyyy-mm-dd)");
						String tempDate = sc.next();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = null;
						date = sdf.parse(tempDate);

						// set Date
						ticket.setJourney_date(date);

						// get current Date
						long millis = System.currentTimeMillis();
						java.sql.Date currentDate = new java.sql.Date(millis);

						if (date.compareTo(currentDate) > 0) {

							List<Availability> busList = busbookingservices.checkAvailability(Source, Destination, date);
							if (busList.size() > 0) {
								for (Availability avail : busList) {
									Bus bus1 = busbookingservices.searchBus(avail.getBusId());
									int availSeats = avail.getAvailSeats();
									System.out.println(bus1);
									System.out.println("Available seats : " + availSeats);
									System.out.println(
											"--------------------------------------------------------------------------------------------------");
								}

								System.out.println("Enter the busId");
								int busId = busbookingservices.validateId(sc.next());
								ticket.setBus_id(busId);

								// get the global userId
								ticket.setUser_id(user_id1);

								Integer availSeats = busbookingservices.checkAvailability(busId, date);
								if (availSeats > 0) {
									System.out.println("Total available seats are: " + availSeats);
									System.out.println("--------------------------------------------------------------");

								}

								System.out.println("Enter number of seats to book");
								int noOfseats = Integer.parseInt(sc.next());
								ticket.setNumofseats(noOfseats);

								Ticket bookedTicket = busbookingservices.bookTicket(ticket);
								System.out.println(bookedTicket);
								if (bookedTicket != null) {
									System.out.println("Ticket sucessfully Booked");
									System.out.println(bookedTicket);
									System.out.println("--------------------------------------------------------------");

								} else {
									throw new BusTicketBookingFailedException("Bus Ticket Booking failed ! enter valid things");
								}
							} else {
								throw new BusNotFoundException("Bus not found");
							}
						} else {
							System.out.println("Invalid date");
						}
					}
					break;
					case 5:
					{
						Ticket ticket = null;
						Boolean Validation = true;
						int user_id1=0;
						while(Validation) {
							System.out.println("Enter user id");
							String userid = sc.next();
							Integer result = busbookingservices.validateId(userid);
							if(result!=null) {
								user_id1 = result;
								validation = false;
								break;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();
							}
						}
						List<Integer> ticketList = busbookingservices.getAllTicket(user_id1);
						if (ticketList.size() > 0) {
							for (Integer bookingId : ticketList) {
								ticket = busbookingservices.getTicket(bookingId);
								System.out.println(ticket);
								System.out.println(
										"--------------------------------------------------------------------------------");
							}
						} else {
							throw new BookedTicketNotFoundException("No tickets Found");
						}
					}
					break;
					case 6:
					{
						int userid1 = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter user id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								userid1 = result;
								validation = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}

						Ticket ticket;
						List<Integer> ticketList = busbookingservices.getAllTicket(userid1);

						if (ticketList.size() > 0) {
							for (Integer bookingId : ticketList) {
								ticket = busbookingservices.getTicket(bookingId);
								System.out.println(ticket);
								System.out.println(
										"-----------------------------------------------------------------------------------------------------------------------");
							}
							System.out.println("Enter the bookingId");
							if (busbookingservices.cancelTicket(sc.nextInt(), userid1)) {
								System.out.println("Ticket cancelled");
								System.out.println("--------------------------------------------------------------");

							} else {
								throw new CancalTicketException("Ticket cancelation Failed");
							}
						}
					}
					break;
					case 7:{
						Feedback feed = new Feedback();

						int uid = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter user id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								uid = result;
								validation = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}

						feed.setUserId(uid);
						System.out.println("Write your feedback here");
						String feed1 = sc.next();
						feed.setFeedback(feed1);
						Boolean feedback = busbookingservices.writeFeedback(feed);
						if (feedback) {
							System.out.println("Feedback added successfully");
						} else {
							FeedbackException feedbackexception = new FeedbackException(
									"FeedbackException : Feedback not added , try again later");
							feedbackexception.getMessage();
						}
					 }
					}
				}
			}
//				else {
//				LoginFailedException loginException = new LoginFailedException("Failed...");
//				loginException.getMessage();
//			}
//		}
		case 2:{
			int adminid = 0;
			Boolean validation = true;
			Boolean login = true;
			while(validation){
				System.out.println("Enter admin id");
				String id = sc.next();
				Integer result = busbookingservices.validateId(id);
				if(result!=null){
					adminid = result;
					login = false;
					}else{
					LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
					loginException.getMessage();				
					}
				
				Admin admin = repo.admin_info.get(result);
				if(admin!=null) {
					System.out.println("Enter the Password");
					   password=sc.next();
				}else {
					LoginFailedException loginException = new LoginFailedException("Admin Login failed..");
					loginException.getMessage();
				}
				
				Boolean adminLogin = busbookingservices.adminLogin(adminid, password);
            if(adminLogin) {
				System.out.println("Admin Login Successful");
				validation = false;
             }
			}
			

				
				Boolean b = true;
				while (b) {
					System.out.println("BUS RESERVATION AND TICKETING SYSTEM  ");
					System.out.println("***********************************************");
					System.out.println("1] Create New Bus");
					System.out.println("2] Update The Bus information");
					System.out.println("3] Search the Bus");
					System.out.println("4] Delete the existing Bus");
					System.out.println("5] Check The Bus Availabilty");
					System.out.println("6] Search User");
					System.out.println("7] View Feedback");
					System.out.println("8] Set Bus Availability");
					System.out.println("9] Check Booked Ticket");
					System.out.println("10] Exit");

					int choice = sc.nextInt();
					switch(choice) {
					case 1:{
						int busId = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter Bus id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								busId = result;
								validate = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}

						System.out.println("Enter Busname");
						busname = sc.next();
						System.out.println("Enter source");
						source = sc.next();
						System.out.println("Enter destination");
						destination = sc.next();
						System.out.println("Enter bus_type");
						bus_type = sc.next();
						System.out.println("Enter total_seats");
						total_seats = sc.nextInt();
						System.out.println("Enter price");
						price = sc.nextDouble();

						bus.setBus_id(busId);
						bus.setBusname(busname);
						bus.setSource(source);
						bus.setDestination(destination);
						bus.setBus_type(bus_type);
						bus.setTotal_seats(total_seats);
						bus.setPrice(price);

						boolean createBus = busbookingservices.createBus(bus);
						if (createBus) {
							System.out.println("Bus Created");
							System.out.println("--------------------------------------------------------------");

						} else {
							BusCreateException busCreateException = new BusCreateException("Bus Not created..");
							busCreateException.getMessage();
						}
					}

					case 2:{
						int busId = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter Bus id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								busId = result;
								validate = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}
						System.out.println("Enter Busname");
						busname = sc.next();
						System.out.println("Enter source");
						source = sc.next();
						System.out.println("Enter destination");
						destination = sc.next();
						System.out.println("Enter bus_type");
						bus_type = sc.next();
						System.out.println("Enter total_seats");
						total_seats = sc.nextInt();
						System.out.println("Enter price");
						price = sc.nextDouble();

						bus.setBus_id(busId);
						bus.setBusname(busname);
						bus.setSource(source);
						bus.setDestination(destination);
						bus.setBus_type(bus_type);
						bus.setTotal_seats(total_seats);
						bus.setPrice(price);

						boolean updateBus = busbookingservices.updateBus(bus);
						if (updateBus) {
							System.out.println("Bus Updated");
						} else {
							throw new BusUpdateException("Bus details not Updated");
						}
					}
					case 3:{
						int busId = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter Bus id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								busId = result;
								validate = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}
						Bus searchBus = busbookingservices.searchBus(busId);
						if (searchBus != null) {
							System.out.println(searchBus);
							System.out.println("--------------------------------------------------------------");

						} else {
							throw new BusNotFoundException("Bus not existed with a following detail");
						}
					}
					case 4:{

						int busId = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter Bus id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								busId = result;
								validate = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}
						Boolean deleteBus = busbookingservices.deleteBus(busId);
						if (deleteBus) {
							System.out.println("Bus data has deleted");
							System.out.println("--------------------------------------------------------------");

						} else {
							throw new DeleteBusException("Bus not Deleted");
						}
					}
					case 5:{
						System.out.println("Enter a choice");
						System.out.println("Check Availability by \n1.Bus id\n2.Source and Destination");
						int chAvail = Integer.parseInt(sc.next());
						if (chAvail == 1) {
							int busId = 0;
							boolean validate = true;
							while (validate) {
								System.out.println("Enter Bus id");
								String id = sc.next();
								Integer result = busbookingservices.validateId(id);
								if (result != null) {
									busId = result;
									validate = false;
								} else {
									LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
									loginException.getMessage();								}
							}
							System.out.println("Enter date of journey(yyyy-mm-dd)");
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String tempDate = sc.next();
							Date date = sdf.parse(tempDate);
							System.err.println(date + "in main");
							System.out.println("----------------------------------------------");

							Integer availSeats = busbookingservices.checkAvailability(busId, date);
							if (availSeats != null) {
								System.out.println("Total available seats are: " + availSeats);
							}

						} else if (chAvail == 2) {
							System.out.println("Enter source point");
							String source1 = sc.next();
							System.out.println("Enter Destination point");
							String destination1 = sc.next();

							System.out.println("Enter date of journey(yyyy-mm-dd)");
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String tempDate = sc.next();
							Date date = sdf.parse(tempDate);
							System.err.println(date + "in main");
							System.out.println("----------------------------------------------");

							List<Availability> busList = busbookingservices.checkAvailability(source1, destination1, date);
							System.out.println(busList);
							for (Availability avail : busList) {
								Bus bus1 = busbookingservices.searchBus(avail.getBusId());
								int availSeats = avail.getAvailSeats();
								System.out.println(avail);
								System.out.println(bus1);
								System.out.println(availSeats);
								System.out.println("Available seats : " + availSeats);
								System.out.println(
										"--------------------------------------------------------------------------------------------------");
							}
						}
					}
					case 6:{
						int userid = 0;
						boolean idvalidation = true;
						while (idvalidation) {
							System.out.println("Enter user id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								userid = result;
								idvalidation = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}
						User tempuser = busbookingservices.searchUser(userid);
						if (tempuser != null) {
							System.out.println(tempuser);
							System.out.println("--------------------------------------------------------------");

						} else {
							System.out.println("User doesn't exist");
						}
					}
					case 7:{

						List<Feedback> feedList = busbookingservices.viewFeedback();
						System.out.println(feedList);
						if (feedList.size() > 0) {
							System.out.println("Feedbacks are:");
							for (Feedback feed : feedList) {
								System.out.println(feed);
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------");
							}
						} else {
							throw new UserFeedbackException("No feedback found");
						}

					}
					case 8:
					{
						Availability availability = new Availability();
						int busId = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter Bus id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								busId = result;
								validate = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();							}
						}
						Bus bus1 = busbookingservices.searchBus(busId);
						if (bus1 != null) {
							availability.setBusId(busId);
							System.out.println("Enter the Available seats");
							availability.setAvailSeats(Integer.parseInt(sc.next()));
							System.out.println("Enter date of journey(yyyy-mm-dd)");
							String tempDate = sc.next();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Date date = null;

							date = sdf.parse(tempDate);

							availability.setAvailDate(date);

							if (busbookingservices.setBusAvailability(availability)) {
								System.out.println("Successfully Set the availability");
							}
						} else {
							throw new SetBusAvailabilityException("Failed to Set the availability");
						}
					}
					case 9:
					{
						int busId = 0;
						boolean validate = true;
						while (validate) {
							System.out.println("Enter Bus id");
							String id = sc.next();
							Integer result = busbookingservices.validateId(id);
							if (result != null) {
								busId = result;
								validate = false;
							} else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();								}
						}
						System.out.println("Enter date of journey(yyyy-mm-dd)");
						String tempDate = sc.next();
						SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
						Date date = null;
						try {
							date = sdf.parse(tempDate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						List<Ticket> ticketAL = busbookingservices.getTicketByBus(busId, date);
						if (ticketAL.size() > 0) {
							System.out.println("Tickets are:");
							for (Ticket ticket : ticketAL) {
								System.out.println(ticket);
								System.out.println(
										"---------------------------------------------------------------------------------------------------------------------------------------");
							}
						} else {
						}
					  }
					}
				}
			}
		
					case 3:{
						User user1 = null;
						Boolean Validation = true;
						int user_id1=0;
						while(Validation) {
							System.out.println("Enter user id");
							String userid = sc.next();
							Integer result = busbookingservices.validateId(userid);
							if(result!=null) {
								user_id1 = result;
								Validation = false;
								break;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter the Id as an Integer..");
								loginException.getMessage();
							}
						}						
						user.setUser_id(user_id1);

						System.out.println("Enter the username");
						user.setUsername(sc.next());
						
						String email = null;
						Boolean Validate = true;
						while(Validate) {
							System.out.println("Enter the email id");
							 email = sc.next();
							String result = busbookingservices.validateEmail(email);
							if(result!=null) {
								email = result;
								Validate = false;
							}else {
								LoginFailedException loginFailedException = new LoginFailedException("Enter Valid Email-Id");
								loginFailedException.getMessage();
							}

						}
						user.setEmail(email);
						System.out.println("Enter the password");
						user.setPassword(sc.next());
						
						Boolean validate = true;
						Long contacts=null;
						while(validate) {
							System.out.println("Enter contact");
							String contact = sc.next();
							Long result = busbookingservices.validateContact(contact);
							if(result!=null) {
								contacts = result;
								validate = false;
							}else {
								LoginFailedException loginException = new LoginFailedException("Enter Valid Contact no.");
								loginException.getMessage();
							}
						}
						user.setContact(contacts);
						if(busbookingservices.createUser(user))
						{
							System.out.println("Profile sucessfully created");
						}else
						{
							UserCreationFailedException userCreationFailedException = new UserCreationFailedException("Profile Creation Failed ! try again later");
							userCreationFailedException.getMessage();
						}
					}
					}
				}
}


