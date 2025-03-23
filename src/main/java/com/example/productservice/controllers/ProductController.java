package com.example.productservice.controllers;

import com.example.productservice.ProductServiceApplication;
import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController  //This is for batter readbility its inheritated controller
// This help to create a object of ProductController
@RequestMapping("/products") // RequestMapping is used for define the path
public class ProductController {

    ProductService productService;
// @Qualifier("SelfProductService") here spring responsibility to create object of ProductService and inject it
    public ProductController(@Qualifier("SelfProductService") ProductService productService) { // this is called Constructor injection
        System.out.println("SelfProductService RUN>>>");
       this.productService = productService; // @Qualifier("SelfProductService") can change easily  @Qualifier("FakeStoreService")
    }

    @GetMapping("/{id}") // Its http verb and its provide path variable
    public ResponseEntity<Product>  getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("Product ID : "+id);
        Product product = null;
        product = productService.getProductById(id);
        /*try { // Handle exception instance of if block
            product = productService.getProductById(id);
        } catch (InstanceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }*/
        ResponseEntity<Product> productResponseEntity;
    /*    if(product == null){
            productResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND); // this is one way
            return productResponseEntity;
        }*/

        productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return productResponseEntity;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
            return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        System.out.println(" Product ID : "+id);
        return productService.updateProduct(id,product);
    }
// Im trying to handle exception in a batter way instance of try catch
   /* @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }*/

 /*@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleInstanceNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(e.getId());
        productNotFoundExceptionDto.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleNullPointerException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(e.getId());
        productNotFoundExceptionDto.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }*/

    //Create a product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        System.out.println(" Product ID : "+product.getId());
        return productService.createProduct(product);
    }
}
