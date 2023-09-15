package com.ferafln.finance.service;

import com.ferafln.finance.model.Account;
import com.ferafln.finance.repository.AccountRepository;
import com.ferafln.finance.service.generic.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService extends CrudService<Account, Integer> {

    private final AccountRepository repository;

    @Override
    public AccountRepository getRepository() {
        return repository;
    }

    public List<Account> findByUsername(String username) {
        return repository.findByUsername(username).get()
                ;
    }
}
