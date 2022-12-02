package com.trade24.tradingapp.service;

import com.trade24.tradingapp.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItem(Long id);
    void addItem(Item item);
    void updateItem(Long id, Item item);
    void deleteItem(Long id);
    List<Item> getUserItems(Long userId);
}
