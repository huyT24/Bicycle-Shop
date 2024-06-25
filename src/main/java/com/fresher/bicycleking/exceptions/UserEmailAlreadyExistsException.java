package com.fresher.bicycleking.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -2829071836653556504L;
	
	private String message;

	public UserEmailAlreadyExistsException() {

	}

	public UserEmailAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
