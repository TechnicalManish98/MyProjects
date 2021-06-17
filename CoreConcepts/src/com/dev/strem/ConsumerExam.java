package com.dev.strem;

import java.io.BufferedInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerExam {
	static void reverse(List<Integer> list){  
		// Return sum of list values  
		int result = list.stream()  
				.mapToInt(Integer::intValue)  
				.sum();  
		System.out.println("Sum of list values: "+result); 

	}
	
	 public static void main(String[] args) {  
	        // Creating a list and adding values  
	                List<Integer> list = new ArrayList<>();  
	                list.add(10);  
	                list.add(20);  
	                list.add(30);  
	                list.add(40);  
	        // Referring method to String type Consumer interface   
	        Consumer<List<Integer>> consumer = ConsumerExam::reverse;  
	        consumer.accept(list);  // Calling Consumer method  
	          System.out.println(list);
	          
	          
	          DateTimeFormatter  f = DateTimeFormatter.ofPattern("dd-MMM-yyyy E");
	          String date = LocalDate.parse("2015-08-11").format(f);
	          System.out.println(date);
	          
	          String s1="restructure";  
	          System.out.println(s1.substring(2,3));//returns va 
	          
	          
	          Supplier<Double> randomValue = () -> Math.random(); 
	       // Print the random value using get() 
	          System.out.println(randomValue.get());
	          
	          Supplier<String>  supplier = () -> "Welcome to the Java World";
	          Predicate<String> pred = (str) -> str.length() > 10;
	          System.out.println(pred.test(supplier.get()));
	         
	    }  
}