package com.microservices.account.controller;

import com.microservices.account.dto.AccountDto;
import com.microservices.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/{customer-id}")
    public ResponseEntity<List<AccountDto>> getAllAccounts(@PathVariable("customer-id") Long customerId){
        return new ResponseEntity<>(accountService.getAccountsById(customerId), HttpStatus.OK);
    }

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
}
