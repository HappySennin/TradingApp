package com.trade24.tradingapp.controller;

import com.trade24.tradingapp.entity.Transaction;
import com.trade24.tradingapp.enums.TransactionStatus;
import com.trade24.tradingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public List<Transaction> getUserTransactions(Long userId) {
        return null;
    }

    public void addTransaction(Transaction transaction) {

    }
    public void updateTransaction(Long id, Transaction transaction) {

    }
    public void deleteTransaction(Long id) {

    }
    public void changeTransactionStatus(Long id, TransactionStatus status) {

    }
}
