package com.dev.bbs.beans;

public class Bus
{
	private int bus_id;
	private String busname;
	private String source;
	private String destination;
	private String bus_type;
	private int total_seats;
	private double price;
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
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
	public String getBus_type() {
		return bus_type;
	}
	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}
	public int getTotal_seats() {
		return total_seats;
	}
	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bus [bus_id=" + bus_id + ", busname=" + busname + ", source=" + source + ", destination=" + destination
				+ ", bus_type=" + bus_type + ", total_seats=" + total_seats + ", price=" + price + "]";
	}
	
	

}
