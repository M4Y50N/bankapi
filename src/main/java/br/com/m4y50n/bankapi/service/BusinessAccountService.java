package br.com.m4y50n.bankapi.service;

import java.util.List;

import br.com.m4y50n.bankapi.model.BusinessAccount;
import br.com.m4y50n.bankapi.repository.BusinessAccountRepository;

public class BusinessAccountService {
    private final BusinessAccountRepository businessAccountRepository;

    public BusinessAccountService(BusinessAccountRepository businessAccountRepository) {
        this.businessAccountRepository = businessAccountRepository;
    }

    public BusinessAccount createBusinessAccount(BusinessAccount busAccData) {
        BusinessAccount createdBusinessAccount = new BusinessAccount(busAccData.getBussinessName(),
                busAccData.getRole(), busAccData.getCnpj(), busAccData.getUser());

        return businessAccountRepository.save(createdBusinessAccount);
    }

    public List<BusinessAccount> readBusinessAccounts() {
        return businessAccountRepository.findAll();
    }

    public BusinessAccount retrivBusinessAccount(long id) throws Exception {
        return businessAccountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Business Account not found"));
    }

    public BusinessAccount updateBusinessAccount(BusinessAccount busAccData, long id) throws Exception {
        final BusinessAccount foundBusAcc = businessAccountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Business Account not found"));

        foundBusAcc.setBussinessName(busAccData.getBussinessName());
        foundBusAcc.setRole(busAccData.getRole());
        foundBusAcc.setCnpj(busAccData.getCnpj());
        foundBusAcc.setUser(busAccData.getUser());

        return businessAccountRepository.save(foundBusAcc);
    }

    public void deleteBusinessAccount(long id) throws Exception {
        final BusinessAccount foundBusAcc = businessAccountRepository.findById(id)
                .orElseThrow(() -> new Exception("Error: Business Account not found"));

        businessAccountRepository.delete(foundBusAcc);
    }

}
