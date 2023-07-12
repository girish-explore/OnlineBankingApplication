package com.microservices.account.service;

import com.microservices.account.entity.Transaction;
import com.microservices.account.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transaction> getTransactionsById(Long customerId) {
        return transactionRepository.findByCustomerId(customerId);
    }
}
