package com.caps.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_ver2 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded.....");
			System.out.println("***********************************************");
			//get the connection via Driver


			String url="jdbc:mysql://localhost:3306/caps_mumbai"+"?user=root&password=ROOT";
			conn= DriverManager.getConnection(url);
			System.out.println("connection established....");

			//issue sql query via connection

			String query = "SELECT * FROM users_info";
			stmt = conn.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("query issued...");
			System.out.println("************************************************");

			//process the result
			System.out.println("userid\tusername\temail");
			while(rs.next())
			{
				int userid=rs.getInt("user_id");
				String username=rs.getString("user_name");
				String email=rs.getString("email_id");

				System.out.print(userid+"\t");
				System.out.print(username+"\t");
				System.out.print(email);
				System.out.println();

				System.out.println("********************************************");
			}



		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		//close all the jdbc obj


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