package com.example.productservice.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel{
    String description;
}
