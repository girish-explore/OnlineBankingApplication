package com.microservices.registration.service;

import com.microservices.registration.dto.AccountDto;
import com.microservices.registration.entity.Account;
import com.microservices.registration.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<AccountDto> getAllAccounts(Long customerId) {
        List<Account> accounts=accountRepository.findByCustomerId(customerId);

        List<AccountDto> accountList = new ArrayList<>();

        for (Account account : accounts) {
            AccountDto accountDto=new AccountDto(
                    account.getId(),
                    account.getBalance(),
                    account.getName(),
                    account.getType()
            );
            accountList.add(accountDto);
        }
        return accountList;

    }

    @Override
    public AccountDto depositAccount(Long customerId, String type, Long amount) {
        Account account=accountRepository.findByCustomerIdAndType(customerId,type);
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        AccountDto accountDto=new AccountDto(account.getId(), account.getBalance(), account.getName(),
                account.getType());
        return accountDto;
    }

    @Override
    public AccountDto withdrawAccount(Long customerId, String type, Long amount) {
        Account account=accountRepository.findByCustomerIdAndType(customerId,type);
        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
        AccountDto accountDto=new AccountDto(account.getId(), account.getBalance(), account.getName(),
                account.getType());
        return accountDto;
    }
}
