package com.product.ProductService.controllers;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/")
public class ProductController {
	
	@GetMapping("products/")
	public String getProduct() {
		return "Get Product Called !!! ";
	}
	
	@GetMapping()
	public String getProductById(@PathVariable("id") Long id) {
		return "Get Product id "+id;
	}
}
