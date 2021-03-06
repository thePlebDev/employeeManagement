package com.example.demo.exception;

import java.text.MessageFormat;

public class OrderNotFoundException extends RuntimeException{
	
	public OrderNotFoundException(Long id){
		super(MessageFormat.format("Could not find the order with id {0}", id));
	}

}
