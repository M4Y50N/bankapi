package br.com.m4y50n.bankapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.m4y50n.bankapi.model.BusinessAccount;
import br.com.m4y50n.bankapi.service.BusinessAccountService;

public class BusinessAccountController {
    private final BusinessAccountService businessAccountService;

    public BusinessAccountController(BusinessAccountService businessAccountService) {
        this.businessAccountService = businessAccountService;
    }

    @PostMapping
    public ResponseEntity<BusinessAccount> createBusinessAccount(@RequestBody BusinessAccount busAccDate) {
        final BusinessAccount createdBusinessAccount = businessAccountService.createBusinessAccount(busAccDate);

        return new ResponseEntity<BusinessAccount>(createdBusinessAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessAccount>> readBusinessAccount() {
        final List<BusinessAccount> allBusinessAccounts = businessAccountService.readBusinessAccounts();

        return new ResponseEntity<List<BusinessAccount>>(allBusinessAccounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessAccount> retriveBusinessAccount(@PathVariable String id) throws Exception {
        final BusinessAccount businessAccount = businessAccountService.retrivBusinessAccount(Long.parseLong(id));

        return new ResponseEntity<BusinessAccount>(businessAccount, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessAccount> updateBusinessAccount(@RequestBody BusinessAccount busAccDate,
            @PathVariable String id) throws Exception {
        final BusinessAccount updatedBusinessAccount = businessAccountService.updateBusinessAccount(busAccDate,
                Long.parseLong(id));

        return new ResponseEntity<BusinessAccount>(updatedBusinessAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessAccount(@PathVariable String id) throws Exception {
        businessAccountService.deleteBusinessAccount(Long.parseLong(id));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
