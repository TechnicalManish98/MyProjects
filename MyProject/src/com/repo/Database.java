package com.repo;

import java.util.HashMap;

import com.beans.User;

public class Database {

	static HashMap<Integer,User> map1=new HashMap<Integer,User>();

	public boolean addUser(User u)
	{

		if(!map1.containsKey(u.getId()))
		{
			map1.put(u.getId(),u);

			return true;	
		}
		else {
			return false;
		}
	}
	public boolean updateUser(User u) 
	{
		if(map1.containsKey(u.getId()))
		{
			map1.put(u.getId(),u);
			return true;	

		}else {
			return false;
		}


	}
	public User getUser(int id) {
		if(map1.containsKey(id)) {
			return map1.get(id); //user
		}else
			return null;
	}

	public boolean deleteUser(int id) {
		if(map1.containsKey(id)) {
			map1.remove(id);
			return true;
		}else
			return false;

	}

}
