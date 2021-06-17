package com.dev.core;

import java.util.ArrayList;
import java.util.Iterator;

public class TraditionalCollection {
	public static void main(String[] args) {
		System.out.println("Main Thread Started");
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Manish");
		arr.add("Lande");
		
		
		System.out.println("Names added...");
		
		TesterThread thread = new TesterThread(arr);
		new Thread(thread).start();
		
		Iterator<String> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println("Names: "+ itr.next());
		}
		
		
	}
	

}
