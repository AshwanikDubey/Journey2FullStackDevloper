package com.product.ProductService.services;

import java.util.List;

import javax.management.InstanceNotFoundException;

import com.product.ProductService.models.Product;

public interface ProductService {
	
	public List<Product> getAllProduct();
	
	Product getProductById(Long id) throws InstanceNotFoundException;

	public Product replaceProduct(long id, Product product);

	public Product createProduct(Product product);
}
