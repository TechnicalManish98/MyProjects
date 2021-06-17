package com.dev.strem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Manish","Arbaaz","Amit","Dev","Jeet");
		System.out.println(list);
		Stream<String> st = list.stream();
		System.out.println(st);
		List<String> filteredlist = st.filter(x -> x.startsWith("A")).collect(Collectors.toList());
	System.out.println(filteredlist);
	
	
	List<Integer> list1 = Arrays.asList(10,20,30,40,50,60);
	
Integer value=0;
System.out.println(list1.stream().reduce(value,(prev,current)->prev+current));
	}

}
