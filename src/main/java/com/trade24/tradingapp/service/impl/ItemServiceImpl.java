package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.repository.ItemRepository;
import com.trade24.tradingapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public Item getItem(Long id) {
        return null;
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void updateItem(Long id, Item item) {

    }

    @Override
    public void deleteItem(Long id) {

    }

    @Override
    public List<Item> getUserItems(Long userId) {
        return null;
    }
}
