package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.beans.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

//This program is used to insert the records into the database

public class DaoImplJdbc implements UserDao
{



	public	DaoImplJdbc()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	String url="jdbc:mysql://localhost:3306/caps_mumbai?user=root&password=ROOT";

	@Override
	public boolean CreateUser(User u) {
		String query="INSERT INTO users_info values(?,?,?,?)"; //for inserting data into database
		try(Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query))
		{

			pstmt.setInt(1, u.getId());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());

			int i=pstmt.executeUpdate();
			//this method returns the no. of rows affected by excecution of sql statement
			if(i>0)
			{
				System.out.println("Data inserted");
				return true;
			}else
				System.out.println("Something went wrong");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}