package com.example.savannah_furnitures.DTO;

import com.example.savannah_furnitures.entities.ProductCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank String name,
        @NotNull ProductCategory category,
        boolean onSale,
        BigDecimal salePrice,
        @Min(0) int Stock,
        String description,
        String imageUrl
) {
}
