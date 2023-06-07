package com.example.demo.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	public CustomerIdNotFoundException(String message) {
		super(message);
	}
}
