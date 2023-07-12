package com.microservices.account.service;

import com.microservices.account.dto.AccountDto;
import com.microservices.account.dto.DepositDto;
import com.microservices.account.dto.WithdrawDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(url = "http://localhost:8080", value = "REGISTRATION-SERVICE")
@FeignClient(name = "REGISTRATION-SERVICE")
public interface ApiClient {
    @GetMapping("/registration/accounts/{customer-id}")
    List<AccountDto> getAllAccounts(@PathVariable("customer-id") Long customerId);

    @PutMapping("/registration/account/withdraw")
    AccountDto withdrawAccount(@RequestBody WithdrawDto withdrawDto);
    @PutMapping("/registration/account/deposit")
    AccountDto depositAccount(@RequestBody DepositDto depositDto);
}
