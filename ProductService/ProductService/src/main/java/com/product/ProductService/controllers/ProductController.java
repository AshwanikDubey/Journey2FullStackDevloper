package com.product.ProductService.controllers;

import org.springframework.web.bind.annotation.*;

import com.product.ProductService.models.Product;
import com.product.ProductService.services.ProductService;

@RestController()
@RequestMapping("/")
public class ProductController {
	
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService =productService;
	}
	
	@GetMapping("products/")
	public Product getProduct() {
		return productService.getProduct();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}
}
