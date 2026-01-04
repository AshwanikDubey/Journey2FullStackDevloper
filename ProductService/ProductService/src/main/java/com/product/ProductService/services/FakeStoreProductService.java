package com.product.ProductService.services;

import org.springframework.stereotype.Service;

import com.product.ProductService.models.Product;

@Service
public class FakeStoreProductService implements ProductService {

	@Override
	public Product getProduct() {
		 
		return null;
	}

	@Override
	public Product getProductById(Long id) {
		 
		return null;
	}

}
