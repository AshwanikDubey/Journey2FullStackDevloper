package com.example.productservice.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_student")
@DiscriminatorValue(value = "1")
public class Students  extends User {
    String course;
    String batch;

}
