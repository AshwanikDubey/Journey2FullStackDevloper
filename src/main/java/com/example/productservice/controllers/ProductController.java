package com.example.productservice.controllers;

import com.example.productservice.ProductServiceApplication;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //This is for batter readbility its inheritated controller
// This help to create a object of ProductController
@RequestMapping("/products") // RequestMapping is used for define the path
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) { // this is called Constructor injection
       this.productService = productService;
    }

    @GetMapping("/{id}") // Its http verb and its provide path variable
    public Product getProductById(@PathVariable("id") Long id){
        System.out.println("Product ID : "+id);
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
            return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        System.out.println("Product ID : "+id);
        return productService.updateProduct(id,product);
    }
}
