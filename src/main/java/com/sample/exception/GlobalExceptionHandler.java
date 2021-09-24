package com.sample.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	    @ResponseBody
	    @ExceptionHandler(CustomException.class)
	    public ResponseEntity<ExceptionResponse> handleCustomException(CustomException ex) {
	    	   ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),LocalDate.now(), HttpStatus.BAD_REQUEST.value());
	    	   return ResponseEntity.ok(exceptionResponse);
	    }
	    
	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	    	HttpHeaders headers, HttpStatus status, WebRequest request) {
	    	     Map<String, String> errors = new HashMap<>();

			      ex.getBindingResult().getFieldErrors().forEach(error ->
			              errors.put(error.getField(), error.getDefaultMessage()));  
			      return ResponseEntity.ok(errors);
	    }
	
}
