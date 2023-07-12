package com.microservices.registration.repository;

import com.microservices.registration.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByCustomerId(Long customerId);

    Account findByCustomerIdAndType(Long customerId, String type);
}
