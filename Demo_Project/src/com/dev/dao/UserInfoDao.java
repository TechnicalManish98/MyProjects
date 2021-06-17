package com.dev.dao;

import com.dev.beans.User;

public interface UserInfoDao 
{
	public boolean createProfile(User user);
	
	
	public User retrivalProfile(int id);
	
	public boolean updateprofile(int id) throws Exception;

	public boolean deleteProfile(int id);

}
