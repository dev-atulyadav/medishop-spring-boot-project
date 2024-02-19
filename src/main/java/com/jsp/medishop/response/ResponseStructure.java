package com.jsp.medishop.response;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Atul
 * @param <T>
 */
@Component
@Data
public class ResponseStructure<T> {

	private String msg;
	private T data;
	private int status;

}
