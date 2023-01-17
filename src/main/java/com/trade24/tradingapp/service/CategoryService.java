package com.trade24.tradingapp.service;

import com.trade24.tradingapp.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getCategory(Long id);
    Category addCategory(Category category);
    void updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
