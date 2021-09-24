package com.sample.util;

public class Response {
	
	   private String message;
	   private int statausCode;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String message, int statausCode) {
		super();
		this.message = message;
		this.statausCode = statausCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatausCode() {
		return statausCode;
	}
	public void setStatausCode(int statausCode) {
		this.statausCode = statausCode;
	}
	
	   

}
