package com.dev.methodreference;

public class MethodReferenceTester {
	
	public static void main(String[] args) {
		String a=new String("a");
		String b=new String("a");
		System.out.println(a==b);
		
		Thread thread = new Thread(MethodReference :: threadStatus);
		thread.start();
		
		Thread thread1 = new Thread(new MethodReference( ) :: show);
		thread1.start();
		
		Tester tester = new MethodReference() :: displaySomething;
		tester.display();
		
		ConFnInterface c = MethodRefConstructor:: new;
		c.login(123);
				
	}

}
