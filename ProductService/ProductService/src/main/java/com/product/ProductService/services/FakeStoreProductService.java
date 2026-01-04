package com.product.ProductService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.ProductService.dtos.FakeStoreProductDto;
import com.product.ProductService.models.Category;
import com.product.ProductService.models.Product;

@Service
public class FakeStoreProductService implements ProductService {
	
	RestTemplate restTemplate;
	
	public FakeStoreProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<Product> getAllProduct() { 
		FakeStoreProductDto fakeStoreProductDTo[]= restTemplate.getForObject("https://fakestoreapi.com/products", 
				FakeStoreProductDto[].class);
		
		List<Product> products = new ArrayList<>();
		for(FakeStoreProductDto ft : fakeStoreProductDTo) {
			products.add(convertDtoToObject(ft));
		}
		 return products;
	}
  
	@Override
	public Product getProductById(Long id) { 
		FakeStoreProductDto fakeStoreProductDTo= restTemplate
				.getForObject("https://fakestoreapi.com/products/"+id,
				FakeStoreProductDto.class);
		 return convertDtoToObject(fakeStoreProductDTo);
	}
	
	private Product convertDtoToObject(FakeStoreProductDto fakeStoreProductDto) {
		System.out.println("Inside convertDtoToObject !!! ");
	    if (fakeStoreProductDto == null) {
	        return null; // safeguard against null input
	    }

	    Product product = new Product();
	    product.setId(fakeStoreProductDto.getId());
	    product.setTitle(fakeStoreProductDto.getTitle());
	    product.setPrice(fakeStoreProductDto.getPrice());
	    product.setDescription(fakeStoreProductDto.getDescription());

	    if (fakeStoreProductDto.getCategory() != null) {
	        Category category = new Category();
	        category.setId(fakeStoreProductDto.getId());
	        category.setTitle(fakeStoreProductDto.getCategory());
	        product.setCategory(category);
	    } 
	    return product;
	}

	
	
	

}
