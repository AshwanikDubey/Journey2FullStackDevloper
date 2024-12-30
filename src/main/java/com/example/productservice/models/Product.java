package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class  Product extends BaseModel {
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
