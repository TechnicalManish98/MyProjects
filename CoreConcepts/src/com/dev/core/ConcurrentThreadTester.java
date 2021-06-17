package com.dev.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentThreadTester implements Runnable{
	
	
	
	CopyOnWriteArrayList<String> List = new CopyOnWriteArrayList<String>();

	public ConcurrentThreadTester(CopyOnWriteArrayList<String> arr) {
		this.List = arr;
		
	}


	@Override
	public void run() {
		System.out.println("Child Thread Class...");
		this.List.add("Name");
		this.List.add("Name2");
		this.List.add("Name3");
		
	}


}
