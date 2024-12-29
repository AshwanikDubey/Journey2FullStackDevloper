package com.example.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "jt_student")
public class Students  extends User {
    String course;
    String batch;

}
