package com.example.demo.exception;

import java.text.MessageFormat;

public class ItemNotFoundException extends RuntimeException{
	
	public ItemNotFoundException(Long id) {
		super(MessageFormat.format("Could not find order with id:{0}", id));
	}

}
