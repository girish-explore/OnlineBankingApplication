package com.microservices.registration.controller;

import com.microservices.registration.dto.AccountDto;
import com.microservices.registration.dto.DepositDto;
import com.microservices.registration.dto.WithdrawDto;
import com.microservices.registration.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts/{customer-id}")
    public ResponseEntity<List<AccountDto>> getAllAccounts(@PathVariable("customer-id") Long customerId){
        return new ResponseEntity<>(accountService.getAllAccounts(customerId), HttpStatus.OK);
    }
    @PutMapping("/account/withdraw")
    public ResponseEntity<AccountDto> withdrawAccount(@RequestBody WithdrawDto withdrawDto){
        return new ResponseEntity<>(accountService.withdrawAccount(withdrawDto.getId(), withdrawDto.getType(),
                withdrawDto.getAmount()),HttpStatus.OK);
    }
    @PutMapping("/account/deposit")
    public ResponseEntity<AccountDto> depositAccount(@RequestBody DepositDto depositDto){
        return new ResponseEntity<>(accountService.depositAccount(depositDto.getId(), depositDto.getType(),
                depositDto.getAmount()),HttpStatus.OK);
    }

}
