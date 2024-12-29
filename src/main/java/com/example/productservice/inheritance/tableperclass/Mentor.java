package com.example.productservice.inheritance.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_mentor")
@DiscriminatorValue(value = "2")
public class Mentor  extends User {
    String companyName;
    String avgRating;
}
