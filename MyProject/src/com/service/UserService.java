package com.service;

import com.beans.User;

public interface UserService 
{
	public boolean CreateUser(User u);

	public boolean updateUser(User u);
	
	public User getUser(int id);
	
	public boolean deleteUser(int id);


}
