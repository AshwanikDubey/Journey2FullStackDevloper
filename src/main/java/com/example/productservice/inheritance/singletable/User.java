package com.example.productservice.inheritance.singletable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
    Long id;
    String name;
    String email;
    String password;
}
