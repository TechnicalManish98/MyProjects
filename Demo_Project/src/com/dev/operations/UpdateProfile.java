package com.dev.operations;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.services.UserServiceImpl;
import com.dev.services.UserServices;

public class UpdateProfile 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		UserServices services=new UserServiceImpl();		
		System.out.println("Enter the userid");
		int userid=sc.nextInt();
//		System.out.println("Enter the password");
//		String password=(sc.nextLine());
		boolean b= services.updateprofile(userid);
		if(b) {
			System.out.println("Data updated");

		}
		else {
			System.out.println("Failed to update");
		}

	}

}
