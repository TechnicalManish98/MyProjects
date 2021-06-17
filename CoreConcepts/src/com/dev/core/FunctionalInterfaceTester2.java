package com.dev.core;

public class FunctionalInterfaceTester2 {
	public static void main(String[] args) {
		FuncInterface func = () ->
		{
			System.out.println("lambda Expression...");
			System.out.println("showing....");

		};
		func.show();
		
		Runnable runnable = () -> System.out.println("Running....");
//		runnable.run();
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
}