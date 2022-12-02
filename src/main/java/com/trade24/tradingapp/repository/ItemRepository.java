package com.trade24.tradingapp.repository;

import com.trade24.tradingapp.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
