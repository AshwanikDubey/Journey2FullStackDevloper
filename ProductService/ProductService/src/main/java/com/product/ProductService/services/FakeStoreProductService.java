package com.product.ProductService.services;

import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
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
	public Product getProductById(Long id) throws InstanceNotFoundException { 
		FakeStoreProductDto fakeStoreProductDTo= restTemplate
				.getForObject("https://fakestoreapi.com/products/"+id,
				FakeStoreProductDto.class);
		 if (fakeStoreProductDTo == null) {
		        throw new InstanceNotFoundException("Product not found for Id : "+id); // safeguard against null input
		    }
		 return convertDtoToObject(fakeStoreProductDTo);
	}
	
	private Product convertDtoToObject(FakeStoreProductDto fakeStoreProductDto) { 
	   

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

	@Override
	public Product replaceProduct(long id, Product product) {
		// Update a product based on their Id and product data
		//Here put only update not return product so we override put method
		//restTemplate.put("https://fakestoreapi.com/products/"+id, product);
		
		//Convert Product to Dto (Serialization)
		FakeStoreProductDto fsp = new FakeStoreProductDto();
		fsp.setCategory(product.getCategory().getTitle());
		fsp.setDescription(product.getDescription());
		fsp.setId(product.getId());
		fsp.setPrice(product.getPrice());
		fsp.setTitle(product.getTitle());
		
		
		//Create requestCallback and pass to execute method
		RequestCallback requestCallback = restTemplate
				.httpEntityCallback(fsp,FakeStoreProductDto.class);
		
		//Custom responseExtractor for FakeStoreProductDto class
		ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = 
				restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
		
		FakeStoreProductDto fsto= restTemplate.execute("https://fakestoreapi.com/products/"+id,
				HttpMethod.PUT,
				requestCallback, responseExtractor).getBody();
System.out.println("Updated Product");
		return convertDtoToObject(fsto); 
	}

	@Override
	public Product createProduct(Product product) {

		//Convert Product to Dto (Serialization)
		FakeStoreProductDto fsp = new FakeStoreProductDto();
		fsp.setCategory(product.getCategory().getTitle());
		fsp.setDescription(product.getDescription());
		fsp.setId(product.getId());
		fsp.setPrice(product.getPrice());
		fsp.setTitle(product.getTitle());
		
		 //Pass DTO and Response type
		RequestCallback requestCallback = restTemplate.httpEntityCallback(fsp, FakeStoreProductDto.class);
		
		HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
				new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
		
		//Getting add product as DTO
		FakeStoreProductDto fsto=  restTemplate.execute("https://fakestoreapi.com/products", HttpMethod.POST, requestCallback, responseExtractor);
		System.out.println("createProduct called "); 
		return convertDtoToObject(fsto);
		 
		 
	}
 
}
