package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.entity.User;
import com.trade24.tradingapp.repository.ItemRepository;
import com.trade24.tradingapp.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceImplTest {
    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemService = new ItemServiceImpl(itemRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllItems() {
        // given
        Item item = new Item();
        item.setName("item");
        Item item2 = new Item();
        item2.setName("item2");
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(item, item2));
        // when
        List<Item> items = itemService.getAllItems();
        // then
        assertEquals(2, items.size());
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("item")));
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("item2")));
    }

    @Test
    void testGetAllItemsEmptyList() {
        // given
        Mockito.when(itemRepository.findAll()).thenReturn(Collections.emptyList());
        // when
        List<Item> items = itemService.getAllItems();
        // then
        assertTrue(items.isEmpty());
    }

    @Test
    void testGetItem() {
        // given
        Item item = new Item();
        item.setName("item");
        item.setId(1L);
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        // when
        Item result = itemService.getItem(1L);
        // then
        assertNotNull(result);
        assertEquals("item", result.getName());
    }

    @Test
    void testGetItemNotFound() {
        // given
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.empty());
        // when
        Item result = itemService.getItem(1L);
        // then
        assertNull(result);
    }

    @Test
    void testAddItem() {
        // given
        Item item = new Item();
        item.setName("item");
        item.setId(1L);
        // when
        itemService.addItem(item);
        //then
        verify(itemRepository, times(1)).save(any());
    }

    @Test
    void testUpdateItemWhenItemFound() {
        // given
        Item item = new Item();
        item.setName("item");
        item.setId(1L);
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        Item itemToUpdate = new Item();
        itemToUpdate.setName("new name");
        itemToUpdate.setId(2L);
        // when
        itemService.updateItem(1L, itemToUpdate);
        //then
        verify(itemRepository, times(1)).delete(item);
        verify(itemRepository, times(1)).save(itemToUpdate);
    }

    @Test
    void testUpdateItemWhenNewItem() {
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.empty());
        Item itemToUpdate = new Item();
        itemToUpdate.setName("new name");
        itemToUpdate.setId(2L);
        // when
        itemService.updateItem(1L, itemToUpdate);
        //then
        verify(itemRepository, never()).delete(any());
        verify(itemRepository, times(1)).save(itemToUpdate);
    }

    @Test
    void testDeleteItem() {
        // when
        itemService.deleteItem(1L);
        //then
        verify(itemRepository, times(1)).deleteById(any());
    }

    @Test
    void testGetUserItemsWithMatch() {
        // given
        User user = new User();
        user.setId(1L);
        User user2 = new User();
        user2.setId(2L);
        Item item = new Item();
        item.setName("item");
        item.setOwner(user);
        Item item2 = new Item();
        item2.setName("item2");
        item2.setOwner(user2);
        Item item3 = new Item();
        item3.setName("item3");
        item3.setOwner(user2);
        Item item4 = new Item();
        item4.setName("item4");
        item4.setOwner(user);
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(item, item2, item3, item4));
        // when
        List<Item> items = itemService.getUserItems(1L);
        //then
        assertEquals(2, items.size());
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("item")));
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("item4")));
    }

    @Test
    void testGetUserItemsWithNoMatch() {
        // given
        User user = new User();
        user.setId(1L);
        Item item = new Item();
        item.setName("item");
        item.setOwner(user);
        Item item2 = new Item();
        item2.setName("item2");
        item2.setOwner(user);
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(item, item2));
        // when
        List<Item> items = itemService.getUserItems(2L);
        //then
        assertTrue(items.isEmpty());
    }
}