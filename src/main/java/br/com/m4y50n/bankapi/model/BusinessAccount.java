package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity()
@Table(name = "business_accounts")
public class BusinessAccount extends Account{
    @Column(length = 92, nullable = false)
    private String bussiness_name;

    @Column(length = 155, nullable = false)
    private String role;

    @Column(length = 14, nullable = false)
    private String cnpj;

    public BusinessAccount(AccountType type, Double balance, User user, String bussiness_name, String role,
            String cnpj) {
        super(type, balance, user);
        this.bussiness_name = bussiness_name;
        this.role = role;
        this.cnpj = cnpj;
    }

    public String getBussiness_name() {
        return bussiness_name;
    }

    public void setBussiness_name(String bussiness_name) {
        this.bussiness_name = bussiness_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}