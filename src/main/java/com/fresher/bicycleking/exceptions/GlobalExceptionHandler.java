package com.fresher.bicycleking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NoSuchBicycleExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse 
	hanldeNoSuchBicycleExistsException
	(NoSuchBicycleExistsException noSuchBicycleExistsException){
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				noSuchBicycleExistsException.getMessage());
	}
	
	@ExceptionHandler(value = UserEmailAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handleUserEmailAlreadyExistsException
	(UserEmailAlreadyExistsException userEmailAlreadyExistsException) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				userEmailAlreadyExistsException.getMessage());
	}
	
	@ExceptionHandler(value = UsernameAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public
	@ResponseBody ErrorResponse 
	handleUsernameAlreadyExistsException
	(UsernameAlreadyExistsException usernameAlreadyExistsException) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				usernameAlreadyExistsException.getMessage());
	}
}
