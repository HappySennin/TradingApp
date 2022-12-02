package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Transaction;
import com.trade24.tradingapp.enums.TransactionStatus;
import com.trade24.tradingapp.repository.TransactionRepository;
import com.trade24.tradingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getUserTransactions(Long userId) {
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }

    @Override
    public void updateTransaction(Long id, Transaction transaction) {

    }

    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public void changeTransactionStatus(Long id, TransactionStatus status) {

    }
}
