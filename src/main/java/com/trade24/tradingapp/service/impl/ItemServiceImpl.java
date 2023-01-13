package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.repository.ItemRepository;
import com.trade24.tradingapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return StreamSupport.stream(this.itemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Item getItem(Long id) {
        return this.itemRepository.findById(id).orElse(null);
    }

    @Override
    public void addItem(Item item) {
        this.itemRepository.save(item);
    }

    @Override
    public void updateItem(Long id, Item item) {
        Item oldItem = this.itemRepository.findById(id).orElse(null);
        if (oldItem != null) {
            this.itemRepository.delete(oldItem);
        }

        this.itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getUserItems(Long userId) {
        List<Item> result = new ArrayList<>();
        this.itemRepository.findAll().forEach(item -> {
            if (item.getOwner().getId() == userId) {
                result.add(item);
            }
        });

        return result;
    }
}
