package com.product.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	Long id;
	String title;
	double price;
	String description;
	Category category;
}
