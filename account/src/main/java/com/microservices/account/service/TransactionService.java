package com.microservices.account.service;

import com.microservices.account.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactionsById(Long customerId);
}
