package com.miApp.AppS.controller;

import com.miApp.AppS.dto.CategoryDTO;
import com.miApp.AppS.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/categories")

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoriService, CategoryService categoryServiceService) {
        this.categoryService = categoryServiceService;

    }

    @GetMapping ("/all")
    public ResponseEntity <List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping ("/{categoryId}")
    public ResponseEntity <CategoryDTO> getCategoryById(Long categoryId) {
        CategoryDTO category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/create")
    public ResponseEntity <CategoryDTO> createCategory(CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(categoryDTO);
    }
}
