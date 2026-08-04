package com.example.savannah_furnitures.service.Impl;

import com.example.savannah_furnitures.DTO.CategoryRequestDTO;
import com.example.savannah_furnitures.DTO.CategoryResponseDTO;
import com.example.savannah_furnitures.entities.ProductCategory;
import com.example.savannah_furnitures.repository.ProductCategoryRepository;
import com.example.savannah_furnitures.service.ProductCategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional
    public CategoryResponseDTO createProductCategory(CategoryRequestDTO dto) {
        if (productCategoryRepository.existsByNameIgnoreCase(dto.name())) {
            throw new IllegalArgumentException("Category already exists: " + dto.name());
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(dto.name());
        productCategory.setSlug(dto.slug());
        productCategory.setDescription(dto.description());
        return CategoryResponseDTO.from(productCategoryRepository.save(productCategory));
    }

    @Override
    @Transactional
    public CategoryResponseDTO updateProductCategory(Long id, CategoryRequestDTO dto) {
        ProductCategory category = productCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + id));
        category.setName(dto.name());
        category.setSlug(dto.slug());
        category.setDescription(dto.description());
        return CategoryResponseDTO.from(category);
    }

    @Override
    @Transactional
    public void deleteProductCategory(Long id) {
        if (!productCategoryRepository.existsById(id)) {
            throw new NoSuchElementException("Category not found: " + id);
        }
        productCategoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponseDTO getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id)
                .map(CategoryResponseDTO::from)
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + id));
    }

    @Override
    public List<CategoryResponseDTO> getAllProductCategories() {
        return productCategoryRepository.findAll().stream()
                .map(CategoryResponseDTO::from)
                .toList();
    }
}