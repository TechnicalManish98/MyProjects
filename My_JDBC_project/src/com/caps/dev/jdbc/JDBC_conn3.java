package com.caps.dev.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

////This program is used to retrieve the records from the database


public class JDBC_conn3  {
	public static void main(String[] args) 
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//load the driver


			java.sql.Driver div=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver Loaded....");

			//get db connection via driver
			//version 3 of getconnection()
			
			String url ="jdbc:mysql://localhost:3306/caps_mumbai";
			String path="C:/Users/DELL/Desktop/java project/My_JDBC_project/jdbc.properties";
			FileReader fr = new FileReader(path);
			Properties prop=new Properties();
			prop.load(fr);		
			
			conn= DriverManager.getConnection(url,prop);
			System.out.println("connection established");
			System.out.println("************************************************");

			//issue sql query via connection
			String query = "SELECT * FROM users_info";
			stmt = conn.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("query issued...");
			System.out.println("************************************************");

			//process the result

			while(rs.next())
			{
				int userid=rs.getInt("user_id");
				String username=rs.getString("user_name");
				String email=rs.getString("email_id");

				System.out.println(userid);
				System.out.println(username);
				System.out.println(email);
				System.out.println("********************************************");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		//close all the jdbc object

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
