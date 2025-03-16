package com.example.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "mps_mentor")
public class Mentor  extends User{
    String companyName;
    String avgRating;
}
