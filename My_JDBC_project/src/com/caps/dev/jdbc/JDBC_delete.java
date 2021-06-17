package com.caps.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.PreparedStatement;

//This program is used to delete the records from the database table

public class JDBC_delete {
	public static void main(String[] args) 
	{
		//load the driver
		java.sql.Driver div;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("driver loaded......");
			
			// get the connection via driver
			
			String dburl ="jdbc:mysql://localhost:3306/caps_mumbai";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the user");
			String user= sc.nextLine();
			System.out.println("Enter the password");
			String password=sc.nextLine();
			
			conn = DriverManager.getConnection(dburl, user, password);
			System.out.println("connection established");
			System.out.println("****************************************************");
			
			//Issue sql Query via connection
			
			String Query ="DELETE from users_info" + "  WHERE user_id=?";
			pstmt =conn.prepareStatement(Query);
			
			System.out.println("Enter the user id");
			int userid = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter the username");
//			String username=sc.nextLine();
//			System.out.println("Enter the email");
//			String email = sc.nextLine();
//			System.out.println("Enter the password");
//			String passwrd= sc.nextLine();
			
			pstmt.setInt(1, userid);
//			pstmt.setString(2, username);
//			pstmt.setString(3, email);
//			pstmt.setString(4, passwrd);
			
			int i=pstmt.executeUpdate();

			// process the result
			if(i>0)
			{
				System.out.println("DATA deleted");
			}
			else
			{
				System.out.println("Failed to delete the data");
			}
			System.out.println("Executed");
		} 
		catch (SQLException e) {
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
				if(pstmt!=null)
				{
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		}
	}

}
