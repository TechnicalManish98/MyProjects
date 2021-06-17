package com.dao;

import com.beans.User;
import com.repo.Database;

public class UserDaoImpl implements UserDao {
	Database d=new Database();
	@Override
	public boolean CreateUser(User u) {

		return d.addUser(u);
	}
	@Override
	public boolean updateUser(User u) {
		return d.updateUser(u);
	}
	@Override
	public User getUser(int id) {
		return d.getUser(id);
	}
	@Override
	public boolean deleteUser(int id) {
		return d.deleteUser(id);
	}
	
}
