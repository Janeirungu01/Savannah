package com.example.savannah_furnitures.DTO;

import com.example.savannah_furnitures.entities.Product;
import com.example.savannah_furnitures.entities.ProductCategory;
import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        ProductCategory category,
        BigDecimal price,
        boolean onSale,
        BigDecimal salePrice,
        int stock,
        String description,
        String imageUrl
) {
    public static ProductResponseDTO from(Product p) {
        return new ProductResponseDTO(
                p.getId(), p.getName(), p.getCategory(), p.getPrice(),
                p.isOnSale(), p.getSalePrice(), p.getStock(),
                p.getDescription(), p.getImageURL()
        );
    }
}