//Write a program using JDBC to find the details of the 'user' on basis of their 'user ids'.

package com.caps.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdetails_retrival {
	public static void main(String[] args) {
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		try {

			//load the driver
			java.sql.Driver div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver is loaded.......");
			System.out.println("********************************");

			// Get the DB connection via Driver
			String url="jdbc:mysql://localhost:3306/caps_mumbai";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the User Name");
			String user=sc.nextLine();
			System.out.println("Enter the password");
			String password=sc.nextLine();
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established..........");

			System.out.println("******************************");

			//Issue SQL Query via connection
			System.out.println("Enter the user id");
			int id=Integer.parseInt(sc.nextLine());
			String query= "SELECT * from users_info WHERE user_id="+id;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("Query Issued");

			//Processing the Query

			rs.next();

			System.out.println(rs.getInt("user_id"));
			System.out.println(rs.getString("user_name"));
			System.out.println(rs.getString("email_id"));


		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.out.println("all the objects of jdbc is closed");


			}

		} 

	}
}