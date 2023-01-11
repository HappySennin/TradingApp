package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public List<Item> getAllItems() {
        return this.itemService.getAllItems();
    }

    @GetMapping("/:id")
    public Item getItem(Long id) {
        return this.itemService.getItem(id);
    }

    @PostMapping
    public void addItem(Item item) {
        this.itemService.addItem(item);
    }

    @PutMapping
    public void updateItem(Long id, Item item) {
        this.itemService.updateItem(id, item);
    }

    @DeleteMapping("/:id")
    public void deleteItem(Long id) {
        this.itemService.deleteItem(id);
    }

    @GetMapping("/:id/all")
    public List<Item> getUserItems(Long userId) {
        return this.itemService.getUserItems(userId);
    }
}
