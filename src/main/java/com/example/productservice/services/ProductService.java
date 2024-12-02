package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();
}
