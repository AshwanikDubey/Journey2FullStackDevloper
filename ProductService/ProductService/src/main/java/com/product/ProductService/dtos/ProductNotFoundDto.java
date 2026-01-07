package com.product.ProductService.dtos;

public class ProductNotFoundDto {
	long errorcode;
	String errormessage;
	public long getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(long errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
}
