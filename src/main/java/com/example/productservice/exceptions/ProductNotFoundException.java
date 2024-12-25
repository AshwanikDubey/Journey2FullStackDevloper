package com.example.productservice.exceptions;

import lombok.Data;

@Data
public class ProductNotFoundException extends Exception {
    private Long id;
   /* private String productName;*/
    public ProductNotFoundException(Long id, String productName) {
        super(productName);
        this.id = id;
    }
    public ProductNotFoundException() {

    }
}
