package com.management.product.exceptions;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(int id) {
		super("Could not find product id : " + id);
	}
	
	public ProductNotFoundException() {
		super("Product not found");
	}

}
