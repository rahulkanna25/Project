package com.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(DriverNotFoundException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderNotFoundException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ErrorResponse> handleException(EmptyListException exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler()
	public ResponseEntity<ErrorResponse> handleException(Exception exe)
	{
		ErrorResponse err= new ErrorResponse();
	    err.setTimestamp(LocalDateTime.now());
		err.setStatus( HttpStatus.BAD_REQUEST);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.BAD_REQUEST);
	}
	

}
