package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service  // Service is batter naming in service component is avaliable and spring will provide object of service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate ; // for calling fakestore most basic this is create a http client then i can create request than i can call.
    // A batter way we can create RestTemplate which is provide by spring framework


    public FakeStoreProductService(RestTemplate restTemplate) { // Inject the object of rest template via constuctor
      this.restTemplate  = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
// DTO stand for Data Transfer Object its contract between 2 services when i call your Api i will get data in this form
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class); // Here we convert JSON to Object and its called  Descrilization
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        // call to DTO
        FakeStoreProductDto[] fakeStoreProductDtoList =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class); // return type is array of fakestore DTO
        // for return list of product we need to convert dto to product list
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDtoList) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto1));
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        restTemplate.put("https://fakestoreapi.com/products/" + id, product);// Time 51:32
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {

        if(fakeStoreProductDto == null){
            return null;
        }
// here we convert fakestore DTO to product
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());


        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }


}
