package com.example.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "jt_mentor")
public class Mentor  extends User {
    String companyName;
    String avgRating;
}
