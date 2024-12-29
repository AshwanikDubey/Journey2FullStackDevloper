package com.example.productservice.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_mentor")
@DiscriminatorValue(value = "2")
public class Mentor  extends User {
    String companyName;
    String avgRating;
}
