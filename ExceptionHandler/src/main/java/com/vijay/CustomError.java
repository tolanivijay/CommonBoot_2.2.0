package com.vijay;

import java.time.ZonedDateTime;

public class CustomError {
	
	private String message;
	
	private String cause;
	
	private ZonedDateTime date;
	
	public CustomError(String mess,String cause) {
		this.message= mess;
		this.cause=cause;
		this.date= ZonedDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public ZonedDateTime getDate() {
		return date;
	}

}
