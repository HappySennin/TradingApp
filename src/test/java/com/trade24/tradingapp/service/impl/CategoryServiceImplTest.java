package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Category;
import com.trade24.tradingapp.repository.CategoryRepository;
import com.trade24.tradingapp.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {
    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryServiceImpl(categoryRepository);
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetAllCategory() {
        // given
        Category category = new Category();
        category.setName("Category");
        Category category2 = new Category();
        category2.setName("Category_2");
        Mockito.when(categoryRepository.findAll()).thenReturn(Arrays.asList(category, category2));
        // when
        List<Category> categoryList = categoryService.getAll();
        // then
        assertEquals(2, categoryList.size());
        assertTrue(categoryList.stream().anyMatch(c -> c.getName().equals("Category")));
        assertTrue(categoryList.stream().anyMatch(c -> c.getName().equals("Category_2")));
    }

    @Test
    void testGetCategory() {
        // given
        Category category = new Category();
        category.setName("Category");
        category.setId(1L);
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        // when
        Category result = categoryService.getById(1L);
        // then
        assertNotNull(result);
        assertEquals("Category", result.getName());
    }

    @Test
    void testAddCategory() {
        // given
        Category category = new Category();
        category.setName("Category");
        category.setId(1L);
        // when
        categoryService.addCategory(category);
        //then
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    void testDeleteCategory() {
        // when
        categoryService.deleteCategory(1L);
        //then
        verify(categoryRepository, times(1)).deleteById(any());
    }
}
