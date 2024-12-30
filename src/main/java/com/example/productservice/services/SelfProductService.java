package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repos.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
@Primary //  required a single bean, but 2 were found: to avoid we used @primary annotation or self-service declared as Qualifier on controller
public class SelfProductService implements ProductService {

    ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
}
