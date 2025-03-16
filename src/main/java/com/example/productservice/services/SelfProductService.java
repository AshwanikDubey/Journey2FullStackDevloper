package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductTitleAndDescription;
import com.example.productservice.repos.CategoryRepo;
import com.example.productservice.repos.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService") // specify a name and pass name as qualifier
@Primary //  required a single bean, but 2 were found: to avoid we used @primary annotation or self-service declared as Qualifier on controller
public class SelfProductService implements ProductService {

    private final CategoryRepo categoryRepo;
    ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        // BY Using HQL
        ProductTitleAndDescription productTitleAndDescription = productRepo.getProductTitleAndDescription(id);
        System.out.println("Projection :: "+productTitleAndDescription.getTitle() + " " + productTitleAndDescription.getDescription());

        // By Using SQl
        ProductTitleAndDescription productTitleAndDescriptionSQL = productRepo.getProductTitleAndDescription(id);
        System.out.println("Projection :: "+productTitleAndDescriptionSQL.getTitle() + " " + productTitleAndDescriptionSQL.getDescription());


        //return ProductTitleAndDescription.getProductTitleAndDescription(id);
        return productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
        //return productRepo.findById(id).get();// By default, in JPA collections is Lazy Loaded
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category saveCategory = categoryRepo.save(category);
            product.setCategory(saveCategory);
        }else{
            // we should check if category is valid or not
        }

        return productRepo.save(product);
    }
}
