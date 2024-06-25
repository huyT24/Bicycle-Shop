package com.fresher.bicycleking.exceptions;

public class NoSuchBicycleExistsException extends RuntimeException {
	private static final long serialVersionUID = -868942433424984673L;
	private String message;

	public NoSuchBicycleExistsException() {
	}

	public NoSuchBicycleExistsException(String message) {
		super(message);
		this.message = message;
	}
}
