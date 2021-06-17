package com.dev.bbs.beans;

public class User 
{
	private int user_id;
	private String username;
	private String email;
	private String password;
	private long contact;
	
	public int getUser_id() {
	return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + "]";
	}
	
	
	
	

}
