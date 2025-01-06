package com.example.productservice.repos;

import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Product is Object name and :id is refer to Param id
    @Query("select p.title as Title,p.description as Description from Product p where p.id = :id")
    ProductTitleAndDescription getProductTitleAndDescription(@Param("id") Long id);

    @Query(value ="select title ,description from product where id = :id", nativeQuery = true)
    ProductTitleAndDescription getProductTitleAndDescriptionSQL(@Param("id") Long id);
}
