package com.trade24.tradingapp.service;

import com.trade24.tradingapp.entity.Transaction;
import com.trade24.tradingapp.enums.TransactionStatus;

import java.util.List;

public interface TransactionService {
    List<Transaction> getUserTransactions(Long userId);
    void addTransaction(Transaction transaction) throws Exception;
    void updateTransaction(Long id, Transaction transaction);
    void deleteTransaction(Long id);
    void changeTransactionStatus(Long id, TransactionStatus status);
}
