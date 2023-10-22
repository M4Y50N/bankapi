package br.com.m4y50n.bankapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.m4y50n.bankapi.model.Account;
import br.com.m4y50n.bankapi.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody final Account accData) {
        final Account createdAccount = accountService.createAccount(accData);

        return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account>> readAccounts() {
        final List<Account> allAccounts = accountService.readAccounts();

        return new ResponseEntity<List<Account>>(allAccounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> retriveAccount(@PathVariable String id) throws Exception {
        final Account account = accountService.retriveAccount(Long.parseLong(id));

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody final Account accData, @PathVariable String id)
            throws Exception {
        final Account account = accountService.updateAccount(accData, Long.parseLong(id));

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) throws Exception {
        accountService.deleteAccount(Long.parseLong(id));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }
}
