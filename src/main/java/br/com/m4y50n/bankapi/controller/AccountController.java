package br.com.m4y50n.bankapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.m4y50n.bankapi.model.Account;
import br.com.m4y50n.bankapi.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> readAccounts(){
        final List<Account> allAccounts = accountService.readAccounts();

        return new ResponseEntity<List<Account>>(allAccounts, HttpStatus.OK);
    }

}
