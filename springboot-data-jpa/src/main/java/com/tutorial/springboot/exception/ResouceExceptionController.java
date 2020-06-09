package com.tutorial.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResouceExceptionController {
	
   @ExceptionHandler(value = ResourceNotFoundException.class)
   public ResponseEntity<Object> exception(ResourceNotFoundException exception, WebRequest request) {
	   
	   CustomExceptionResponseMessage exceptionResponse = new CustomExceptionResponseMessage(new Date(), exception.getMessage(),
				request.getDescription(false));
      return new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
   }
}
