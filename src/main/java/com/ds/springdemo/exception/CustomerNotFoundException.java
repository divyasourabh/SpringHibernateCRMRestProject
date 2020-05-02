package com.ds.springdemo.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException() {
	}
		
	public CustomerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
}
