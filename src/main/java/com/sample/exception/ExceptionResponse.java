package com.sample.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	   private String message;
	   private LocalDate timestamp;	
	   private int statusCode;
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionResponse(String message, LocalDate timestamp, int statusCode) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	   
	   
	 
	   
	   
	   
}
