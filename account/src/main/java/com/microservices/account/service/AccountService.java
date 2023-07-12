package com.microservices.account.service;


import com.microservices.account.dto.AccountDto;
import com.microservices.account.dto.DepositDto;
import com.microservices.account.dto.WithdrawDto;
import com.microservices.account.entity.Transaction;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAccountsById(Long customerId);

    AccountDto withdrawAccount(WithdrawDto withdrawDto);

    AccountDto depositAccount(DepositDto depositDto);

}
