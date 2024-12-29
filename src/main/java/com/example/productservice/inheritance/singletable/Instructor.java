package com.example.productservice.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_instructor") // Entity is creating object mapping relationship. Entity try to creating table of the Object with attribute
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    String specilaistion;
}
