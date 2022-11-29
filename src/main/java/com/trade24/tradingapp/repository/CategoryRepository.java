package com.trade24.tradingapp.repository;

import com.trade24.tradingapp.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
