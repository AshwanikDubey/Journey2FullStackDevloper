package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel{
    String description;
    @OneToMany(fetch = FetchType.EAGER)
    List<Product> productList;

}
