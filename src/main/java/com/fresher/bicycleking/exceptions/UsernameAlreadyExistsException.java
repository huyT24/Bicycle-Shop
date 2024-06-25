package com.fresher.bicycleking.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UsernameAlreadyExistsException() {
		
	}
	
	public UsernameAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
