package com.springBoot.exceptions;

public class ProductException extends RuntimeException{

	public ProductException() {
		
	}
	
	public ProductException(String message) {
		
		super(message);
	}
}
