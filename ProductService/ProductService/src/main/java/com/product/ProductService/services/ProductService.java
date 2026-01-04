package com.product.ProductService.services;

import java.util.List;

import com.product.ProductService.models.Product;

public interface ProductService {
	
	public List<Product> getAllProduct();
	
	Product getProductById(Long id);
}
