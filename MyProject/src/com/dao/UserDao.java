package com.dao;

import com.beans.User;

public interface UserDao {
	
	public boolean CreateUser(User u);
	
	public boolean updateUser(User u);
	
	public User getUser(int id);
	
	public boolean deleteUser(int id);



}
