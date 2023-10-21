package br.com.m4y50n.bankapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.m4y50n.bankapi.model.Account;
import br.com.m4y50n.bankapi.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> readAccounts() {
        return accountRepository.findAll();
    }
}
