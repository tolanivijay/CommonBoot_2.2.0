package com.vijay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<CustomError> mapException(Exception e) {
		
		return new ResponseEntity<CustomError>(new CustomError("Exception caught",e.getMessage()), HttpStatus.BAD_GATEWAY);
	}
}
