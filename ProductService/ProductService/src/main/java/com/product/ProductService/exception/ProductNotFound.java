package com.product.ProductService.exception;

public class ProductNotFound extends Exception{
	private long id;
	private String message;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProductNotFound(long id,String message) {
		super(message);
		this.id=id;
	}
	
}
