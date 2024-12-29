package com.example.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "mps_instructor") // Entity is creating object mapping relationship. Entity try to creating table of the Object with attribute
public class Instructor extends User{
    String specilaistion;
}
