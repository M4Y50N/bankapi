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
        return accountRepository.findById(id).orElseThrow(() -> new Exception("Error: Account not find"));
    }

    public Account updateAccount(Account accData, long id) throws Exception {
        Account updatedAccount = accountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Account not find"));

        updatedAccount.setType(accData.getType());

        return accountRepository.save(updatedAccount);
    }

    public void deleteAccount(long id) throws Exception {
        Account foundAccount = accountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Account not find"));

        accountRepository.delete(foundAccount);
    }
}
