package com.trade24.tradingapp.service.impl;

import com.trade24.tradingapp.entity.Item;
import com.trade24.tradingapp.entity.Transaction;
import com.trade24.tradingapp.enums.TransactionStatus;
import com.trade24.tradingapp.repository.TransactionRepository;
import com.trade24.tradingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Transaction> result = new ArrayList<>();
        this.transactionRepository.findAll().forEach(transaction -> {
            if (transaction.getOwner().getId() == userId) {
                result.add(transaction);
            }
        });

        return result;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public void updateTransaction(Long id, Transaction transaction) {
        Transaction oldTransaction = this.transactionRepository.findById(id).orElse(null);
        if (oldTransaction != null) {
            this.transactionRepository.delete(oldTransaction);
        }

        this.transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        this.transactionRepository.deleteById(id);
    }

    @Override
    public void changeTransactionStatus(Long id, TransactionStatus status) {
        Transaction transaction = this.transactionRepository.findById(id).orElse(null);
        transaction.setStatus(status);
        this.transactionRepository.delete(transaction);
        this.transactionRepository.save(transaction);
    }
}
