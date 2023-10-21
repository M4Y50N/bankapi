package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "business_accounts")
public class BusinessAccount extends _Base {
    @Column(length = 92, nullable = false)
    private String bussiness_name;

    @Column(columnDefinition = "DECIMAL DEFAULT 0.0")
    private Double balance;

    @Column(length = 155, nullable = false)
    private String role;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public BusinessAccount(String bussiness_name, String role, String cnpj, User user) {
        this.bussiness_name = bussiness_name;
        this.role = role;
        this.cnpj = cnpj;
        this.user = user;
    }

    public BusinessAccount() {
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}