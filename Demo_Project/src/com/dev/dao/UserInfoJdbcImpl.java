package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dev.beans.User;

public class UserInfoJdbcImpl implements UserInfoDao
{
	Scanner sc=new Scanner(System.in);
	public	UserInfoJdbcImpl()
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
	public boolean createProfile(User user)
	{

		String query="INSERT INTO users_info values(?,?,?,?,?)"; //for inserting data into database
		try(Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query))
		{

			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());

			int i=pstmt.executeUpdate();
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
	public User retrivalProfile(int id)
	{

		String query="SELECT * FROM users_info WHERE userid="+id;
		try(Connection conn = DriverManager.getConnection(url);
				Statement stmt= conn.createStatement();
				ResultSet rs=stmt.executeQuery(query))

		{
			User us=new User();
			while(rs.next())
			{
				us.setUserid(rs.getInt("userid"));
				us.setUsername(rs.getString("username"));
				us.setEmail(rs.getString("email"));
				return us;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public boolean updateprofile(int id) throws Exception
	{
		String Query ="UPDATE users_info SET username=?,email=?,password=? WHERE userid=?";
		System.out.println("Enter the username");
		String name=sc.nextLine();
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String passwrd= sc.next();

		try(	Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(Query))
		{
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, passwrd);
			pstmt.setInt(4, id);
			
			int i=pstmt.executeUpdate();
			// process the result
			if(i>0)
			{
				return true;
			}
			else
			{
				System.out.println("Failed to update the data");
			}
			System.out.println("Executed");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	@Override
	public boolean deleteProfile(int id) {
		String query="DELETE FROM users_info where users_id=?";
		try(	Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query))
		{
			Scanner sc=new Scanner(System.in);
			int userid=Integer.parseInt(sc.nextLine());
			pstmt.setInt(1,userid);
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("data is deleted");
				return true;
			}else {
				System.out.println("not deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return false;
	}

}



