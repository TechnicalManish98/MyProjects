package com.caps.dev.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class JDBC_callable 
{
	public static void main(String[] args)
	{
		Connection conn=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;

		try {
			String url ="jdbc:mysql://localhost:3306/caps_mumbai"+"?user=root&password=ROOT";
			conn= DriverManager.getConnection(url);
			System.out.println("connection established");
			System.out.println("************************************************");

			//issue sql query via connection
			String query = "call sp1()";
			cstmt = conn.prepareCall(query);

			boolean b=cstmt.execute();
			if(b)
			{
				rs=cstmt.getResultSet();
				while(rs.next())
				{
					int userid=rs.getInt("user_id");
					String username=rs.getString("user_name");
					String email=rs.getString("email_id");

					System.out.println(userid);
					System.out.println(username);
					System.out.println(email);
				}
			}
			else
			{
				int i=cstmt.getUpdateCount();
				if(i>0)
				{
					System.out.printf("query ok "," i " + "row changed.........");
				}
			}

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
			if(cstmt!=null) 
			{
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}