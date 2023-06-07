package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

//to create a error response back to the client for that we are creating a class ApiError
public class ApiError {

	private String message; //exception msg info
	private LocalDateTime localDateTime; 
	//date and time exception
	private String endpoint;
	//generate exception
	private HttpStatus httpStatus;
	//error status code
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
