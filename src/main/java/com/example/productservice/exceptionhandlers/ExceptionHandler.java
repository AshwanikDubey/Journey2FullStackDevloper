package com.example.productservice.exceptionhandlers;

import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

// ControllerAdvice will run between client and controller
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleInstanceNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(e.getId());
        productNotFoundExceptionDto.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleNullPointerException(ProductNotFoundException e) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(e.getId());
        productNotFoundExceptionDto.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }


}
