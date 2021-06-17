package com.dev.core;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollection {
	public static void main(String[] args) {
		System.out.println("Main Thread Started....");
		
		CopyOnWriteArrayList<String> arr = new CopyOnWriteArrayList<String>();
		arr.add("Manish");
		arr.add("Lande");
		
		
		System.out.println("Names added....");
		
		ConcurrentThreadTester thread = new ConcurrentThreadTester(arr);
		new Thread(thread).start();
		
		Iterator<String> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println("Names: "+ itr.next());
		}
		
	
	}
}
