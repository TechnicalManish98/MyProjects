package com.dev.strem;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamExample1 {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(9,8,7,6,5,4);
		Stream<Integer> str = list.stream();
		
		
		//Using List
//		List<Integer> filtersort = str.sorted().collect(Collectors.toList());
//		System.out.println(filtersort);
		
//		List<Integer> filteredlist1 = str.filter(x->(x>3)).sorted().collect(Collectors.toList());
//  		System.out.println(filteredlist1);

		//Using Set
//		Set<Integer> filteredlist = str.filter(x->(x>3)).sorted().collect(Collectors.toSet());
//		System.out.println(filteredlist);
  		
  		
		
  		//Using Map
		List<Integer> num = Arrays.asList(1,2,3,4,5);
	    num.stream().map(x -> x*x).forEach(x -> System.out.println(x));
	    
//	    List<Integer> square = num.stream().map(x -> x*x).collect(Collectors.toList());
//	    System.out.println(square);
	    
	    List<Integer> listtt = Arrays.asList(2,4,6,8,9);
	    Stream<Integer> stream = listtt.stream();
	    int value = 0;
	   int sum = stream.reduce(value,(x,y) -> x+y);
	   System.out.println("****************");
	   System.out.println(sum);
	   
	   TreeSet t = new  TreeSet();
	   
	    
	}

}
