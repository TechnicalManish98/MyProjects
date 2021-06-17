package com.dev.core;

public class FunctionalInterfaceTester implements FuncInterface{

	@Override
	public void show() {

		System.out.println("Showing.....");
	}

	public static void main(String[] args) {
		FunctionalInterfaceTester tester = new FunctionalInterfaceTester();
		tester.show();
	}
}
