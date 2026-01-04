package com.product.ProductService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.product.ProductService.models.Product;
import com.product.ProductService.services.ProductService;

@RestController()
@RequestMapping("/products")
public class ProductController {
	
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService =productService;
	}
	
	@GetMapping("/")
	public List<Product> getAllProduct() {
		System.out.println("getProduct is called !!! ");
		return productService.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		System.out.println("getProductById is called !!! ");
		return productService.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product) {
		return productService.replaceProduct(id,product);
	}
}
