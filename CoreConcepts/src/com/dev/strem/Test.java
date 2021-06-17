package com.dev.strem;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;import org.omg.Messaging.SyncScopeHelper;

public class Test {
	public static void main(String[] args) {

		String name = new String("aravind");
		String  p = name.replace('a','*');
		System.out.println(p);
		String n =	p.substring(2,4);
		System.out.println(n);
		int num =		n.indexOf('n');
		System.out.println(num);

		Stream<String> str = Stream.of("Hollow","wow","welcome","wow","world");
		str.filter(ref -> ref.contains("w")).distinct().forEach((x)->System.out.println(x));


		Vector v =new Vector(6,3);
		for(int num1 = 1; num1<=15 ; num1++) 

			v.add(num1);
		System.out.println(v.capacity());

		List<Integer> numList = Arrays.asList(34,10,60,60,3,12,65,1,8);
		numList.stream().filter(nn -> nn<=60 && nn>10).sorted().forEach(System.out::println);
		
		System.out.println("************************************");
		String string = "tests";
		string.chars().forEach(x->System.out.println(x));
		
		List<String> vals = Arrays.asList("a","b","c");
		String join = vals.parallelStream().reduce((a,b) -> a.concat(b).toUpperCase()).get();
		System.out.println(join);
		
	}

}
