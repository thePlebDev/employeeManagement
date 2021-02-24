package com.example.demo.exception;

import java.text.MessageFormat;

public class ItemIsAlreadyAssignedException extends RuntimeException {
	
	public ItemIsAlreadyAssignedException(Long itemId, Long orderId) {
		super(MessageFormat.format("Item{0} is already assigned to cart:{1} ",itemId, orderId));
	}

}
