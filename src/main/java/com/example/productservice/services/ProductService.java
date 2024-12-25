package com.example.productservice.services;

import com.example.productservice.models.Product;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface ProductService {

    Product getProductById(Long id) throws InstanceNotFoundException;

    List<Product> getAllProducts();

    Product updateProduct(Long id,Product product);
}
