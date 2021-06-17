package com.dev.exception;

public class LoginFailedException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginFailedException(String s) {
//		super(s);
		System.err.println(s);
	}

}
