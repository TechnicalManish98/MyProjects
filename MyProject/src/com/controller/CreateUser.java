package com.controller;

import java.util.Scanner;

import com.beans.User;
import com.service.UserService;
import com.service.UserServiceImpl;


public class CreateUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id;
		String name;
		String email;
		String password;
		UserService us=new UserServiceImpl();
		User u=new User();
		boolean l=true;
		while(l) {
			System.out.println("Select a option: ");
			System.out.println("1) Create User");
			System.out.println("2) Update user ");
			System.out.println("3) Retrive user");
			System.out.println("4) Delete user");
			System.out.println("5) exit");

			int i=sc.nextInt();
			switch(i) {
			case 1:
				//create
				System.out.println("Enter emp id");
				id = sc.nextInt();
				System.out.println("Enter name");
				name = sc.next();
				System.out.println("Enter email");
				email = sc.next();
				System.out.println("Enter password");
				password = sc.next();

				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				u.setEmail(email);
				boolean b=us.CreateUser(u);
				if(b) {
					System.out.println("User Data Created");
				}else {
					System.out.println("Something went wrong");
				}

				break;


				//update the user
			case 2:
				//Update
				System.out.println("Enter emp id");
				id = sc.nextInt();
				System.out.println("Enter name");
				name = sc.next();
				System.out.println("Enter email");
				email = sc.next();
				System.out.println("Enter password");
				password = sc.next();

				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				u.setEmail(email);

				if(us.CreateUser(u)) {
					System.out.println("User Data updated");
				}else {
					System.out.println("Something went wrong");
				}
				break;

			case 3:
				System.out.println("Enter emp id");
				id = sc.nextInt();
				User user=us.getUser(id);//user
				if(user!=null) {
					System.out.println(user);
				}else {
					System.out.println("User doesn't exist");
				}
				break;

			case 4:
				//delete
				System.out.println("Enter emp id");
				id = sc.nextInt();

				boolean res = us.deleteUser(id);
				if(res)
				{
					System.out.println("User Successfully Deleted");
				}
				else
				{
					System.out.println("No. such User exists with id: "+id);
				}
				break;

			case 5:
				l=false;
				break;

			}

		}
	}
}