package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Category;
import com.trade24.tradingapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    Category getById(@RequestParam Long id) {
        return null;
    }

    @PostMapping("")
    Category addCategory(Category category) {
        return this.categoryService.addCategory(category);
    }

    @PutMapping("")
    void updateCategory(Long id, Category category) {
        this.categoryService.updateCategory(id, category);
    }

    @DeleteMapping("")
    void deleteCategory(Long id) {
        this.categoryService.deleteCategory(id);
    }
}
