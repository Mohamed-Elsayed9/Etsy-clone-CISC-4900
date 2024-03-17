package com.etsyclone.controller.rest;

import com.etsyclone.entity.Category;
import com.etsyclone.entity.Product;
import com.etsyclone.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/{id}/products")
    public Set<Product> getCategoryProducts(Long id) {
        return categoryService.getCategoryProducts(id);
    }

    @PostMapping
    public void addCategory(Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping
    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }

}
