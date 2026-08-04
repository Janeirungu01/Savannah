package com.example.savannah_furnitures.controllers;

import com.example.savannah_furnitures.DTO.CategoryRequestDTO;
import com.example.savannah_furnitures.DTO.CategoryResponseDTO;
import com.example.savannah_furnitures.service.ProductCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

  @PostMapping
  public ResponseEntity<CategoryResponseDTO> create(@Valid @RequestBody CategoryRequestDTO dto) {
      return ResponseEntity.status(HttpStatus.CREATED).body(productCategoryService.createProductCategory(dto));
  }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO dto) {
        return ResponseEntity.ok(productCategoryService.updateProductCategory(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.getProductCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll() {
        return ResponseEntity.ok(productCategoryService.getAllProductCategories());
    }

}
