package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import lombok.Data;

@Data
public class FakeStoreProductDto {

   Long id;
   String title;
   Double price ;
   String category ;
   String description ;

}
