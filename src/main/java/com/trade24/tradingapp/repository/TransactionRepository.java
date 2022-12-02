package com.trade24.tradingapp.repository;

import com.trade24.tradingapp.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
