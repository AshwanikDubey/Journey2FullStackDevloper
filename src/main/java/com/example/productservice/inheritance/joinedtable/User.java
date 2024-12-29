package com.example.productservice.inheritance.joinedtable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    Long id;
    String name;
    String email;
    String password;
}
