package com.rbrains.springcrud.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rbrains.springcrud.ui.model.response.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(new Date(),ex.toString());
		
		return new ResponseEntity<>(errorResponse, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(new Date(),ex.toString());
		
		return new ResponseEntity<>(errorResponse, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(new Date(),ex.getMessage());
		
		return new ResponseEntity<>(errorResponse, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}
