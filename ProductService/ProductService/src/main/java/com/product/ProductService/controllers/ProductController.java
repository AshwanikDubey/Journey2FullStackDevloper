package com.product.ProductService.controllers;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.ProductService.exception.ProductNotFound;
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
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFound   {
		System.out.println("getProductById is called !!! ");
		Product product =  productService.getProductById(id);
		ResponseEntity<Product> ps;
		if(product == null) {
			ps = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return ps;
		}
		ps = new ResponseEntity<>(product,HttpStatus.OK);
		return ps; 
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product) {
		return productService.replaceProduct(id,product);
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		//Here hold the product
		Product prod =  productService.createProduct(product);
		  
		ResponseEntity<Product> ps;
		//if product null
		if(prod == null) {
			// return NotFound
			ps = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return ps;
		}
		// If product present return ok with Product
		ps = new ResponseEntity<>(product,HttpStatus.OK);
		return ps; 
	}
	//@ExceptionHandler is like a filter run all the method and based on Exception provide response.
	@ExceptionHandler(InstanceNotFoundException.class)
	private ResponseEntity<String> handleInstanceNotFound(InstanceNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
