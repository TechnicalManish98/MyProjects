package com.service;

import com.beans.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao dao=new UserDaoImpl();

	@Override
	public boolean CreateUser(User u) {
		return dao.CreateUser(u);
	}

	@Override
	public boolean updateUser(User u) {
		return dao.updateUser(u);
	}
	@Override
	public User getUser(int id) {
		return dao.getUser(id);
	}

	@Override
	public boolean deleteUser(int id) {
		return dao.deleteUser(id);
	}
}