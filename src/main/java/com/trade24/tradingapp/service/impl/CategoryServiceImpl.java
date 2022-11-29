package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Category;
import com.trade24.tradingapp.repository.CategoryRepository;
import com.trade24.tradingapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAll() {
        List<Category> result = new ArrayList<>();
        categoryRepository.findAll().forEach(result::add);
        return result;
    }
}
