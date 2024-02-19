package com.jsp.medishop.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.medishop.response.ResponseStructure;

/**
 * @author Atul
 */
@RestControllerAdvice
public class ApplicationHandler {

	@Autowired
	private ResponseStructure<InvalidUserCredentialException> structure;

	@ExceptionHandler(InvalidUserCredentialException.class)
	public ResponseStructure<InvalidUserCredentialException> invalid(InvalidUserCredentialException exception) {
		structure.setData(exception);
		structure.setMsg(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		return structure;
	}

}
