package com.microservices.registration.service;

import com.microservices.registration.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts(Long customerId);
    AccountDto depositAccount(Long customerId, String type, Long amount);

    AccountDto withdrawAccount(Long customerId, String type, Long amount);


}
