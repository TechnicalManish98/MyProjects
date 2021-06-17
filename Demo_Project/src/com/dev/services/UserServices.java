package com.dev.services;

import com.dev.beans.User;

public interface UserServices
{
	public boolean createProfile(User user);
	
	public User retrivalProfile(int id);
	
	public boolean updateprofile(int id) throws Exception;

	public boolean deleteProfile(int id);

}
