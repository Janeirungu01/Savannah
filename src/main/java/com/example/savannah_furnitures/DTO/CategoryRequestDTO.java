package com.example.savannah_furnitures.DTO;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank String name,
        @NotBlank String slug,
        String description
) {}
