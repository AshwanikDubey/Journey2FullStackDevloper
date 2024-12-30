package com.example.productservice.repos;

import com.example.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
