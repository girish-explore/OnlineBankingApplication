package com.microservices.account.service;

import com.microservices.account.dto.AccountDto;
import com.microservices.account.dto.DepositDto;
import com.microservices.account.dto.WithdrawDto;
import com.microservices.account.entity.Transaction;
import com.microservices.account.repository.TransactionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    private ApiClient apiClient;
    @Autowired
    private TransactionRepository transactionRepository;

    public AccountServiceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultAccounts")
    @Override
    public List<AccountDto> getAccountsById(Long customerId) {
        return apiClient.getAllAccounts(customerId);
    }

    @Override
    public AccountDto withdrawAccount(WithdrawDto withdrawDto) {
        Transaction newTransaction= new Transaction();
        newTransaction.setCustomerId(withdrawDto.getId());
        newTransaction.setAmount(withdrawDto.getAmount());
        newTransaction.setType("Withdraw");
        newTransaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(newTransaction);
        return apiClient.withdrawAccount(withdrawDto);
    }

    @Override
    public AccountDto depositAccount(DepositDto depositDto) {
        Transaction newTransaction= new Transaction();
        newTransaction.setCustomerId(depositDto.getId());
        newTransaction.setAmount(depositDto.getAmount());
        newTransaction.setType("Deposit");
        newTransaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(newTransaction);
        return apiClient.depositAccount(depositDto);
    }

    public List<AccountDto> getDefaultAccounts(Long customerId,Exception exception) {
        List<AccountDto> accounts= new ArrayList<>();
        AccountDto accountDto1=new AccountDto();
        accountDto1.setId(123456789L);
        accountDto1.setType("current");
        accountDto1.setBalance(1056745L);
        accountDto1.setName("DefaultName1");
        accounts.add(accountDto1);
        AccountDto accountDto2=new AccountDto();
        accountDto1.setId(987654321L);
        accountDto1.setType("savings");
        accountDto1.setBalance(564546L);
        accountDto1.setName("DefaultName2");
        accounts.add(accountDto2);

        return accounts;
    }

}
