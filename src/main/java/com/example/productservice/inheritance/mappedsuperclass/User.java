package com.example.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass // MappedSuperclass annotation make sure all the attributes of user is part of user children
public class User {
    @Id
    Long id;
    String name;
    String email;
    String password;
}
