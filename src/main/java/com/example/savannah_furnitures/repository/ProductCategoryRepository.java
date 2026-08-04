package com.example.savannah_furnitures.repository;

import com.example.savannah_furnitures.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    Optional<ProductCategory> findBySlug(String slug);
    boolean existsByNameIgnoreCase(String name);
}
