package com.ds.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ds.springdemo.exception.CustomerErrorResponse;
import com.ds.springdemo.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException (CustomerNotFoundException customerNotFoundException){

		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(), 
				customerNotFoundException.getMessage(), 
				System.currentTimeMillis());

		return new ResponseEntity<>(customerErrorResponse,HttpStatus.NOT_FOUND);
	}


	//Generic Exceptional Handling
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException (Exception exception){

		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(), 
				exception.getMessage(), 
				System.currentTimeMillis());

		return new ResponseEntity<>(customerErrorResponse,HttpStatus.BAD_REQUEST);
	}
}
