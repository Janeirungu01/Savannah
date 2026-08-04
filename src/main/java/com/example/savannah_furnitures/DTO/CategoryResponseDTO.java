package com.example.savannah_furnitures.DTO;

import com.example.savannah_furnitures.entities.ProductCategory;

public record CategoryResponseDTO(
        Long id,
        String name,
        String slug,
        String description
) {
    public static CategoryResponseDTO from(ProductCategory c) {
        return new CategoryResponseDTO(c.getId(), c.getName(), c.getSlug(), c.getDescription());
    }
}
