package com.example.savannah_furnitures;

import com.example.savannah_furnitures.entities.Product;
import com.example.savannah_furnitures.entities.ProductCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO (
        @NotBlank String name,
        @NotNull ProductCategory category,
        boolean onSale,
        BigDecimal salePrice,
        @Min(0) int Stock,
        String description,
        String imageURL
) {}

public record ProductResponse(
        Long id, String name,
        ProductCategory category,
        BigDecimal price,
        boolean onSale,
        BigDecimal salePrice,
        int stock,
        String description,
        String imageUrl
) {
    public static ProductResponse from(Product p) {
        return new ProductResponse(p.getId(), p.getName(), p.getCategory(), p.getPrice(),
                p.isOnSale(), p.getSalePrice(), p.getStock(), p.getDescription(), p.getImageUrl());
    }
}