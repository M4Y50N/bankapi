package br.com.m4y50n.bankapi.controller;

import br.com.m4y50n.bankapi.service.BusinessAccountService;

public class BusinessAccountController {
    private final BusinessAccountService businessAccountService;

    public BusinessAccountController(BusinessAccountService businessAccountService) {
        this.businessAccountService = businessAccountService;
    }


    

}
