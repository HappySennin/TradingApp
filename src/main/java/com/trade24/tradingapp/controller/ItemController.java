package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Item> getAllItems() {
        return null;
    }

    public Item getItem(Long id) {
        return null;
    }

    public void addItem(Item item) {

    }

    public void updateItem(Long id, Item item) {

    }

    public void deleteItem(Long id) {

    }

    public List<Item> getUserItems(Long userId) {
        return null;
    }
}
