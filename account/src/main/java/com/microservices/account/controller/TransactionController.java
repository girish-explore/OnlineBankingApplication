package com.microservices.account.controller;

import com.microservices.account.dto.AccountDto;
import com.microservices.account.dto.DepositDto;
import com.microservices.account.dto.WithdrawDto;
import com.microservices.account.entity.Transaction;
import com.microservices.account.service.AccountService;
import com.microservices.account.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    private AccountService accountService;
    @GetMapping("/{customer-id}")
    public ResponseEntity<List<Transaction>> getAllAccounts(@PathVariable("customer-id") Long customerId){
        return new ResponseEntity<>(transactionService.getTransactionsById(customerId), HttpStatus.OK);
    }
    @PostMapping("/withdraw")
    public ResponseEntity<AccountDto> withdrawAccount(@RequestBody WithdrawDto withdrawDto){
        return new ResponseEntity<>(accountService.withdrawAccount(withdrawDto),HttpStatus.OK);
    }
    @PostMapping("/deposit")
    public ResponseEntity<AccountDto> depositAccount(@RequestBody DepositDto depositDto){
        return new ResponseEntity<>(accountService.depositAccount(depositDto),HttpStatus.OK);
    }
}
