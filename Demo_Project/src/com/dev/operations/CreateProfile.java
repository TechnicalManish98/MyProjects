package com.dev.operations;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.services.UserServiceImpl;
import com.dev.services.UserServices;

public class CreateProfile {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		User user=new User();
		UserServices us=new UserServiceImpl();

		System.out.println("Enter the user_id");
		user.setUserid(Integer.parseInt(sc.nextLine()));

		System.out.println("Enter the user name");
		user.setUsername(sc.nextLine());

		System.out.println("Enter the email");
		user.setEmail(sc.nextLine());

		System.out.println("Enter the Password");
		user.setPassword(sc.nextLine());

		sc.close();
		System.out.println(user);

		boolean b=us.createProfile(user);

		if(b) 
		{
			System.out.println("Profile Created...");

		}else {
			System.out.println("Failed to create Profile...");
		}

	}
}
