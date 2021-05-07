package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.model.GenericErrorResponse;

@ControllerAdvice
public class GenericRestExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<GenericErrorResponse> handleExcption(Exception e){
		GenericErrorResponse errorResponse=new GenericErrorResponse();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
