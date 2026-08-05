package com.example.savannah_furnitures.repository;

import com.example.savannah_furnitures.entities.Product;
import com.example.savannah_furnitures.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(ProductCategory category);
    List<Product> findByOnSaleTrue();
}
