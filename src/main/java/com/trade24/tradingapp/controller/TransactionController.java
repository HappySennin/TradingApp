package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Transaction;
import com.trade24.tradingapp.enums.TransactionStatus;
import com.trade24.tradingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping()
    public List<Transaction> getUserTransactions(Long userId) {
        return this.transactionService.getUserTransactions(userId);
    }

    @GetMapping("/freeSlots")
    public List<Transaction> getEmptyTransactions() {
//        TODO: add logic
//        return this.transactionService.getEmptyTransactions();
        return null;
    }

    @PostMapping()
    public void addTransaction(Transaction transaction) {
        this.addTransaction(transaction);
    }

    @PutMapping()
    public void updateTransaction(Long id, Transaction transaction) {
        this.updateTransaction(id, transaction);
    }

    @DeleteMapping()
    public void deleteTransaction(Long id) {
        this.transactionService.deleteTransaction(id);
    }

    @PostMapping("/status")
    public void changeTransactionStatus(Long id, Transaction status) {
        this.transactionService.updateTransaction(id, status);
    }
}
