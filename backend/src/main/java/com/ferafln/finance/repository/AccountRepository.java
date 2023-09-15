package com.ferafln.finance.repository;

import com.ferafln.finance.model.Account;
import com.ferafln.finance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<List<Account>> findByUsername(String username);
}
