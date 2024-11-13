package com.spd.productsmicroservice.exception;

import com.spd.productsmicroservice.entity.Product;

public class ProductNotFoundException extends RuntimeException {
	
	private String message;

	public ProductNotFoundException(String message) {
		super(message);
	}
	
}
