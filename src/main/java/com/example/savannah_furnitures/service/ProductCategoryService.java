package com.example.savannah_furnitures.service;

import com.example.savannah_furnitures.DTO.CategoryRequestDTO;
import com.example.savannah_furnitures.DTO.CategoryResponseDTO;

import java.util.List;

public interface ProductCategoryService {
    CategoryResponseDTO createProductCategory(CategoryRequestDTO dto);
    CategoryResponseDTO updateProductCategory(Long id, CategoryRequestDTO dto);
    void deleteProductCategory(Long id);
    CategoryResponseDTO getProductCategoryById(Long id);
    List<CategoryResponseDTO> getAllProductCategories();
}

