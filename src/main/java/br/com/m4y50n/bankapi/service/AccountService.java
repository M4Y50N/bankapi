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

    public Account createAccount(Account accData) {
        Account createdAccount = new Account(accData.getType(), accData.getUser());

        return accountRepository.save(createdAccount);
    }

    public List<Account> readAccounts() {
        return accountRepository.findAll();
    }

    public Account retriveAccount(long id) throws Exception {
        return accountRepository.findById(id).orElseThrow(() -> new Exception("Error: Account not found"));
    }

    public Account updateAccount(Account accData, long id) throws Exception {
        Account foundAccount = accountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Account not found"));

        foundAccount.setType(accData.getType());
        foundAccount.setUser(accData.getUser());

        return accountRepository.save(foundAccount);
    }

    public void deleteAccount(long id) throws Exception {
        Account foundAccount = accountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Account not found"));

        accountRepository.delete(foundAccount);
    }
}
