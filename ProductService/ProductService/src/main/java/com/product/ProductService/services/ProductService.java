package com.product.ProductService.services;

import com.product.ProductService.models.Product;

public interface ProductService {
	
	public Product getProduct();
	
	Product getProductById(Long id);
}
