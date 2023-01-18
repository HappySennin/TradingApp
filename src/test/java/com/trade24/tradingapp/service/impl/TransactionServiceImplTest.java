package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.entity.Transaction;
import com.trade24.tradingapp.entity.User;
import com.trade24.tradingapp.enums.TransactionStatus;
import com.trade24.tradingapp.repository.ItemRepository;
import com.trade24.tradingapp.repository.TransactionRepository;
import com.trade24.tradingapp.service.ItemService;
import com.trade24.tradingapp.service.TransactionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceImplTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    private User user;

    private User user2;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionServiceImpl(transactionRepository);
        MockitoAnnotations.openMocks(this);
        this.user = this.user2 = new User();
        List<User> users = List.of(this.user, this.user2);
        for (int i = 0; i < users.size(); i ++) {
            users.get(i).setId(Long.valueOf(i));
            users.get(i).setName("testName" + String.valueOf(i));
            users.get(i).setSurname("testSurname" + String.valueOf(i));
            users.get(i).setEmail("testMail" + String.valueOf(i));
            users.get(i).setPhoneNumber("+111111111" + String.valueOf(i));
        }
    }

    @Test
    void testGetUserTransaction() {
        // given
        Transaction transaction = new Transaction();
        Item item = new Item();
        item.setName("item");
        item.setOwner(this.user);
        Item item2 = new Item();
        item2.setOwner(this.user);
        item2.setName("item2");

        HashSet itemSet = new HashSet<Item>();
        itemSet.add(item);
        itemSet.add(item2);

        transaction.setOwner(this.user);
        transaction.setId(1L);
        transaction.setOwnerItemsItems(itemSet);
        transaction.setStatus(TransactionStatus.REQUESTED);
        Mockito.when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction));

        // when
        List<Transaction> result = transactionService.getUserTransactions(1L);

        // then
        assertNotNull(result);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getOwner(), this.user);
        assertEquals(result.get(0).getOwnerItemsItems(), itemSet);
    }

    @Test
    void testGetAllTransactionsWithRequester() {
        // given
        Transaction transaction = new Transaction();
        Transaction transaction2 = new Transaction();
        Item item = new Item();
        item.setName("item");
        item.setOwner(this.user);
        Item item2 = new Item();
        item2.setName("item2");
        item2.setOwner(this.user);

        Item item3 = new Item();
        item3.setName("requesterTtem");
        item3.setOwner(this.user2);
        Item item4 = new Item();
        item4.setName("requesterTtem2");
        item4.setOwner(this.user2);

        HashSet itemSet = new HashSet<Item>();
        itemSet.add(item);
        itemSet.add(item2);

        HashSet itemSetRequester = new HashSet<Item>();
        itemSet.add(item3);
        itemSet.add(item4);

        transaction.setOwner(this.user);
        transaction.setRequester(this.user2);
        transaction.setId(1L);
        transaction.setOwnerItemsItems(itemSet);
        transaction.setRequesterItemsItems(itemSetRequester);

        transaction2.setOwner(this.user);
        transaction2.setRequester(this.user2);
        transaction2.setId(2L);
        transaction2.setOwnerItemsItems(itemSet);
        transaction2.setRequesterItemsItems(itemSetRequester);

        Mockito.when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction, transaction2));
        // when
        List<Transaction> transactions = transactionService.getUserTransactions(1L);
        // then
        assertEquals(2, transactions.size());
        assertTrue(transactions.stream().anyMatch(i -> i.getRequester().equals(this.user2)));
        assertTrue(transactions.stream().anyMatch(i -> i.getOwner().equals(this.user)));
    }


    @Test
    void testAddTransaction() {
        // given
        Transaction transaction = new Transaction();
        Item item = new Item();
        item.setName("item");
        Item item2 = new Item();
        item2.setName("item2");

        HashSet itemSet = new HashSet<Item>();
        itemSet.add(item);
        itemSet.add(item2);

        transaction.setOwner(this.user);
        transaction.setId(1L);
        transaction.setStatus(TransactionStatus.REQUESTED);
        transaction.setOwnerItemsItems(itemSet);

        // when
        transactionService.addTransaction(transaction);

        //then
        verify(transactionRepository, times(1)).save(any());
    }

    @Test
    void testUpdateTransaction() {
        // given
        Transaction transaction = new Transaction();
        Item item = new Item();
        item.setName("item");
        Item item2 = new Item();
        item2.setName("item2");

        HashSet itemSet = new HashSet<Item>();
        itemSet.add(item);
        itemSet.add(item2);

        transaction.setOwner(this.user);
        transaction.setId(1L);
        transaction.setStatus(TransactionStatus.REQUESTED);
        transaction.setOwnerItemsItems(itemSet);

        // when
        transactionService.updateTransaction(1L, transaction);

        //then
        verify(transactionRepository, never()).delete(transaction);
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testSetTransactionStatus() {
        // when
        transactionService.deleteTransaction(1L);
        //then
        verify(transactionRepository, times(1)).deleteById(any());
    }

}