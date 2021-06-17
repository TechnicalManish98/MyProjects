package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.UserInfoDao;
import com.dev.dao.UserInfoJdbcImpl;

public class UserServiceImpl implements UserServices{

	UserInfoDao dao=new UserInfoJdbcImpl();
	@Override
	public boolean createProfile(User user) {
		return dao.createProfile(user);
	}
	@Override
	public User retrivalProfile(int id) {

		return dao.retrivalProfile(id);
	}

	@Override
	public boolean updateprofile(int id) throws Exception{
		return dao.updateprofile(id);
	}
//	@Override
//	public boolean deleteProfile(int id) {
//		return dao.deleteProfile(id);
//	}
	@Override
	public boolean deleteProfile(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
