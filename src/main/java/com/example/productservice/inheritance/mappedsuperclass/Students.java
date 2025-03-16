package com.example.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "mps_student")
public class Students  extends User{
    String course;
    String batch;

}
