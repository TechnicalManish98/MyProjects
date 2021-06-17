package com.dev.operations;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.services.UserServiceImpl;
import com.dev.services.UserServices;

public class RetrivalProfile 
{
	public static void main(String[] args)
	{

		User user=new User();
		UserServices us=new UserServiceImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user id");
		int id=sc.nextInt();
		user =us.retrivalProfile(id);

		if(user!=null) 
		{
			System.out.println(user);

		}else {
			System.out.println("Failed to retrieve Profile...");
		}


	}
}
